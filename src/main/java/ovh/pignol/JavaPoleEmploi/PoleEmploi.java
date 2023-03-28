package ovh.pignol.JavaPoleEmploi;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.prefs.PreferenceChangeEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import ovh.pignol.JavaSelenium.Chrome;
import ovh.pignol.JavaSelenium.Probe;
import ovh.pignol.JavaSelenium.WebBrowser;

public class PoleEmploi extends Probe 
{
	public PoleEmploi()
	{
		super();
	}
	
	@Override
	public void mProbe()
	{		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		try(WebBrowser vBrowser = new Chrome())
		{
			this.mConnect(vBrowser);
			if
			(
				!(vBrowser.mPageSource().contains("Nous sommes désolés mais nous ne pouvons prendre en compte une nouvelle déclaration."))
				&&
				!(vBrowser.mPageSource().contains("Prochaine actualisation"))
			)				
			{
				this.mActualise(vBrowser);
				this.mActualisePage2(vBrowser);
				this.mValiderReponse(vBrowser);
			}
			this.mQuitter(vBrowser);
		}
		catch (Exception e)
		{		
			e.printStackTrace();
		}
	}
	
	private void mConnect(WebBrowser pBrowser)
	{
		String vURL = "https://pole-emploi.fr/accueil";
		if(this.mTestSite(pBrowser, vURL))
		{
			WebElement vPopup = pBrowser.mFindElement(By.id("PopinOperationFranceTV"));
			if(vPopup != null)
			{
				WebElement vCloseButton = vPopup.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/button"));
				if(vCloseButton != null && vCloseButton.isDisplayed() && vCloseButton.isEnabled())
				{
					vCloseButton.click();
					this.mPause(1, 3);
				}
			}
			WebElement vLEmission = pBrowser.mFindElement(By.tagName("ngb-modal-window"));
			if(vLEmission != null)
			{
				WebElement vCloseButton = pBrowser.mFindElement(By.xpath("/html/body/ngb-modal-window/div/div/app-popin-pub/div/div[1]/button"));
				if(vCloseButton != null && vCloseButton.isDisplayed() && vCloseButton.isEnabled())
				{
					vCloseButton.click();
					this.mPause(1, 3);
				}
			}
			WebElement vCookies = pBrowser.mFindElement(By.id("tc-privacy-wrapper"));
			if(vCookies != null)
			{
				WebElement vCloseButton = pBrowser.mFindElement(By.id("footer_tc_privacy_button_2"));
				if(vCloseButton != null && vCloseButton.isDisplayed() && vCloseButton.isEnabled())
				{
					vCloseButton.click();
					this.mPause(1, 3);
				}
			}

			this.mPause(1, 3);
			
			WebElement vConnectButton = pBrowser.mFindElement(By.xpath("/html/body/app-root/app-header/header/div/ul/li/div/button"));//By.id("dropdownMenu2"));
			if(vConnectButton != null)
			{
				if(vConnectButton.isDisplayed()&& vConnectButton.isEnabled())
				{
					vConnectButton.click();
					this.mPause(1, 5);
					WebElement vCandidatButton = pBrowser.mFindElement(By.className("menu-link-candidat"));
					if(vCandidatButton != null && vCandidatButton.isDisplayed() && vCandidatButton.isEnabled())
					{
						vCandidatButton.click();
						this.mPause(5, 1);
					}
				}
			}
			WebElement vIdentifiant = pBrowser.mFindElement(By.xpath(EPreferencesFields.User.mXPath()));
			if(vIdentifiant != null)
			{
				if(vIdentifiant.isDisplayed() && vIdentifiant.isEnabled())
				{
					vIdentifiant.sendKeys(PoleEmploiPreferences.mInstance().mUser());
					WebElement vSubmitButton = pBrowser.mFindElement(By.id("submit"));
					if(vSubmitButton != null)
					{
						if(vSubmitButton.isDisplayed() && vSubmitButton.isEnabled())
						{
							vSubmitButton.click();
							this.mPause(1, 5);
							WebElement vPassword = pBrowser.mFindElement(By.xpath(EPreferencesFields.Password.mXPath()));
							if(vPassword != null)
							{
								if(vPassword.isDisplayed() && vPassword.isEnabled())
								{
									vPassword.sendKeys(PoleEmploiPreferences.mInstance().mPassword());
									WebElement vSubmitButton2 = pBrowser.mFindElement(By.id("submit"));
									if(vSubmitButton2 != null && vSubmitButton2.isDisplayed() && vSubmitButton2.isEnabled())
									{
										vSubmitButton2.click();
										this.mPause(1, 3);
									}
								}
							}
						}
					}
				}
			}			
		}
	}
	
	private void mActualise(WebBrowser pBrowser)
	{	
		WebElement vActualiseLink = pBrowser.mFindElement(By.xpath("//*[@id=\"step4\"]/div[1]/pn-menu-navigation/div[2]/div/ul/li[1]/div/button"));
		if(vActualiseLink != null)
		{
			if(vActualiseLink.isDisplayed() && vActualiseLink.isEnabled())
			{
				vActualiseLink.click();
				this.mPause(1, 3);
				WebElement vActualiseButton = pBrowser.mFindElement(By.xpath("//*[@id=\"collapsePlusServiceAccueil-actualisation\"]/div/ul/li[1]/a"));
				if(vActualiseButton != null)
				{
					if(vActualiseButton.isDisplayed() && vActualiseButton.isEnabled())
					{
						vActualiseButton.click();
						this.mPause(1, 3);
					}
				}
			}
		}
		
		if(pBrowser.mPageSource().contains("Passer à l'étape suivante"))
		{
			WebElement vPasser = pBrowser.mFindElement(By.xpath("/html/body/div/div[2]/div/div[1]/div[2]/div/div[1]/form/div/div[2]/ul/li[3]/span/button"));
			if(vPasser != null)
			{
				if(vPasser.isDisplayed() && vPasser.isEnabled())
				{
					vPasser.click();
					this.mPause(1, 3);
				}
			}
		}		
		
		if(pBrowser.mPageSource().contains("Vous avez déjà déclaré votre situation pour cette période"))
		{
			WebElement vModifierButton = pBrowser.mFindElement(By.xpath("/html/body/div/div[2]/div/div[1]/div[2]/div/div[1]/form/div/div[2]/ul/li[3]/span/button"));
			if(vModifierButton != null)
			{
				if(vModifierButton.isDisplayed() && vModifierButton.isEnabled())
				{
					vModifierButton.click();
					this.mPause(1, 3);
				}
			}
		}
		
		if(pBrowser.mPageSource().contains("Déclarer ma situation"))
		{
			WebElement vPasser = pBrowser.mFindElement(By.xpath("//*[@id=\"btn-declare-actu\"]"));
			if(vPasser != null)
			{
				if(vPasser.isDisplayed() && vPasser.isEnabled())
				{
					vPasser.click();
					this.mPause(1, 3);
				}
			}
		}
		
		WebElement vWorked;/* //*[@id="action-activite-oui"] //*[@id="action-activite-non"] */
		if(PoleEmploiPreferences.mInstance().mWorkedYes())
		{
			vWorked = pBrowser.mFindElement(By.xpath(EPreferencesFields.WorkedYes.mXPath()));
		}
		else
		{
			vWorked = pBrowser.mFindElement(By.xpath(EPreferencesFields.WorkedNo.mXPath()));
		}
		if(vWorked != null && vWorked.isDisplayed() && vWorked.isEnabled())		
		{
			vWorked.click();
			this.mPause(1, 3);
		}
		
		if(PoleEmploiPreferences.mInstance().mWorkedYes())
		{
			if(PoleEmploiPreferences.mInstance().mWorkedForSociety())
			{
				WebElement vWorkedForSociety = pBrowser.mFindElement(By.xpath(EPreferencesFields.WorkedForSociety.mXPath()));
				if(vWorkedForSociety != null && vWorkedForSociety.isDisplayed() && vWorkedForSociety.isEnabled())		
				{
					vWorkedForSociety.click();
					this.mPause(1, 3);
				}
			}
			if(PoleEmploiPreferences.mInstance().mWorkedMySociety())
			{
				WebElement vWorkedMySociety = pBrowser.mFindElement(By.xpath(EPreferencesFields.WorkedMySociety.mXPath()));
				if(vWorkedMySociety != null && vWorkedMySociety.isDisplayed() && vWorkedMySociety.isEnabled())		
				{
					vWorkedMySociety.click();
					this.mPause(1, 3);
				}
			}
			WebElement vWorkedSociety = pBrowser.mFindElement(By.xpath(EPreferencesFields.WorkedSociety.mXPath()));
			if(vWorkedSociety != null && vWorkedSociety.isDisplayed() && vWorkedSociety.isEnabled())
			{
				vWorkedSociety.sendKeys(PoleEmploiPreferences.mInstance().mWorkedSociety());
			}
			WebElement vWorkHours = pBrowser.mFindElement(By.xpath(EPreferencesFields.WorkHours.mXPath()));
			if(vWorkHours != null && vWorkHours.isDisplayed() && vWorkHours.isEnabled())
			{
				vWorkHours.sendKeys(PoleEmploiPreferences.mInstance().mWorkHours().toString());
			}
			WebElement vSalaryAmount = pBrowser.mFindElement(By.xpath(EPreferencesFields.SalaryAmount.mXPath()));
			if(vSalaryAmount != null && vSalaryAmount.isDisplayed() && vSalaryAmount.isEnabled())
			{
				vSalaryAmount.sendKeys(PoleEmploiPreferences.mInstance().mSalaryAmount().toString());
			}
			Select vWorkFrom = new Select(pBrowser.mFindElement(By.xpath(EPreferencesFields.WorkFrom.mXPath())));
			if(vWorkFrom != null && ((WebElement) vWorkFrom).isDisplayed() && ((WebElement) vWorkFrom).isEnabled())
			{
				if(PoleEmploiPreferences.mInstance().mWorkFrom().equals("0: null"))
				{
					vWorkFrom.selectByValue(PoleEmploiPreferences.mInstance().mWorkFrom());
				}
				else
				{
					String vValue;
					LocalDate vDate = LocalDate.now();
					Integer vMonth;
					if(vDate.getDayOfMonth() < 16)
					{
						if(vDate.getMonthValue() == 1)
						{
							vMonth = 12;
						}
						else
						{
							vMonth = vDate.getMonthValue() - 1;
						}
					}
					else
					{
						vMonth = vDate.getMonthValue();
					}	
					Integer vYear = vDate.getYear();
					Calendar vCalendar = Calendar.getInstance();
					vCalendar.clear();
					vCalendar.set(vYear, vMonth - 1, 1);
					Integer vMaxDays = vCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
					if(Integer.parseInt(PoleEmploiPreferences.mInstance().mWorkFrom()) > vMaxDays)
					{
						vValue = vMaxDays.toString() + "/" + vMonth.toString() + "/" + vYear.toString();
					}
					else
					{
						vValue = PoleEmploiPreferences.mInstance().mWorkFrom() + "/" + vMonth.toString() + "/" + vYear.toString();
					}
					vWorkFrom.selectByValue(vValue);
				}
			}
			Select vWorkTo = new Select(pBrowser.mFindElement(By.xpath(EPreferencesFields.WorkFrom.mXPath())));
			if(vWorkTo != null && ((WebElement) vWorkTo).isDisplayed() && ((WebElement) vWorkFrom).isEnabled())
			{
				if(PoleEmploiPreferences.mInstance().mWorkTo().equals("0: null"))
				{
					vWorkTo.selectByValue(PoleEmploiPreferences.mInstance().mWorkTo());
				}
				else
				{
					String vValue;
					LocalDate vDate = LocalDate.now();
					Integer vMonth;
					if(vDate.getDayOfMonth() < 16)
					{
						if(vDate.getMonthValue() == 1)
						{
							vMonth = 12;
						}
						else
						{
							vMonth = vDate.getMonthValue() - 1;
						}
					}
					else
					{
						vMonth = vDate.getMonthValue();
					}	
					Integer vYear = vDate.getYear();
					Calendar vCalendar = Calendar.getInstance();
					vCalendar.clear();
					vCalendar.set(vYear, vMonth - 1, 1);
					Integer vMaxDays = vCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
					if(Integer.parseInt(PoleEmploiPreferences.mInstance().mWorkTo()) > vMaxDays)
					{
						vValue = vMaxDays.toString() + "/" + vMonth.toString() + "/" + vYear.toString();
					}
					else
					{
						vValue = PoleEmploiPreferences.mInstance().mWorkTo() + "/" + vMonth.toString() + "/" + vYear.toString();
					}
					vWorkTo.selectByValue(vValue);
				}
			}
		}
		
		WebElement vValidateButton = pBrowser.mFindElement(By.xpath("//*[@id=\"submit-activites\"]"));
		if(vValidateButton != null && vValidateButton.isDisplayed() && vValidateButton.isEnabled())		
		{
			vValidateButton.click();
			this.mPause(1, 3);
		}
	}
	
	private void mActualisePage2(WebBrowser pBrowser)
	{
		WebElement vStage;
		if(PoleEmploiPreferences.mInstance().mStageYes())
		{
			vStage = pBrowser.mFindElement(By.xpath(EPreferencesFields.StageYes.mXPath()));			
		}
		else
		{
			vStage = pBrowser.mFindElement(By.xpath(EPreferencesFields.StageNo.mXPath()));			
		}
		if(vStage != null && vStage.isDisplayed() && vStage.isEnabled())		
		{
			vStage.click();
			this.mPause(1, 3);
		}

		if(PoleEmploiPreferences.mInstance().mStageYes())
		{
			WebElement vStageName = pBrowser.mFindElement(By.xpath(EPreferencesFields.StageName.mXPath()));
			if(vStageName != null && vStageName.isDisplayed() && vStageName.isEnabled())
			{
				vStageName.sendKeys(PoleEmploiPreferences.mInstance().mStageName());
			}
			WebElement vStageFrom = pBrowser.mFindElement(By.xpath(EPreferencesFields.StageFrom.mXPath()));
			if(vStageFrom != null && vStageFrom.isDisplayed() && vStageFrom.isEnabled())
			{
				vStageFrom.sendKeys(PoleEmploiPreferences.mInstance().mStageFrom());
			}
			WebElement vStageTo = pBrowser.mFindElement(By.xpath(EPreferencesFields.StageTo.mXPath()));
			if(vStageTo != null && vStageTo.isDisplayed() && vStageTo.isEnabled())
			{
				vStageTo.sendKeys(PoleEmploiPreferences.mInstance().mStageTo());
			}
		}
		WebElement vMaladie;
		if(PoleEmploiPreferences.mInstance().mDeaceaseBreakYes())
		{
			vMaladie = pBrowser.mFindElement(By.xpath(EPreferencesFields.DeaceaseBreakYes.mXPath()));			
		}
		else
		{
			vMaladie = pBrowser.mFindElement(By.xpath(EPreferencesFields.DeaceaseBreakNo.mXPath()));			
		}
		if(vMaladie != null && vMaladie.isDisplayed() && vMaladie.isEnabled())	
		{
			vMaladie.click();
			this.mPause(1, 3);
		}
		if(PoleEmploiPreferences.mInstance().mDeaceaseBreakYes())
		{
			WebElement vMaladieFrom = pBrowser.mFindElement(By.xpath(EPreferencesFields.DeaceaseBreakFrom.mXPath()));
			if(vMaladieFrom != null && vMaladieFrom.isDisplayed() && vMaladieFrom.isEnabled())
			{
				vMaladieFrom.sendKeys(PoleEmploiPreferences.mInstance().mDeaceaseBreakFrom());
			}
			WebElement vMaladieTo = pBrowser.mFindElement(By.xpath(EPreferencesFields.DeaceaseBreakTo.mXPath()));
			if(vMaladieTo != null && vMaladieTo.isDisplayed() && vMaladieTo.isEnabled())
			{
				vMaladieTo.sendKeys(PoleEmploiPreferences.mInstance().mDeaceaseBreakTo());
			}
		}
		
		WebElement vRetraite;
		if(PoleEmploiPreferences.mInstance().mNewRetreatRentYes())
		{
			vRetraite = pBrowser.mFindElement(By.xpath(EPreferencesFields.NewRetreatRentYes.mXPath()));
		}
		else
		{
			vRetraite = pBrowser.mFindElement(By.xpath(EPreferencesFields.NewRetreatRentNo.mXPath()));
		}
		if(vRetraite != null && vRetraite.isDisplayed() && vRetraite.isEnabled())
		{
			vRetraite.click();
			this.mPause(1, 3);
		}
		
		if(PoleEmploiPreferences.mInstance().mNewRetreatRentYes())
		{
			if(PoleEmploiPreferences.mInstance().mNewRetreatRent())
			{
				WebElement vNewRetreatRent = pBrowser.mFindElement(By.xpath(EPreferencesFields.NewRetreatRent.mXPath()));
				if(vNewRetreatRent != null && vNewRetreatRent.isDisplayed() && vNewRetreatRent.isEnabled())
				{
					vNewRetreatRent.click();
					WebElement vRetreatRentFrom = pBrowser.mFindElement(By.xpath(EPreferencesFields.NewRetreatRentFrom.mXPath()));
					if(vRetreatRentFrom != null && vRetreatRentFrom.isDisplayed() && vRetreatRentFrom.isEnabled())
					{
						vRetreatRentFrom.sendKeys(PoleEmploiPreferences.mInstance().mNewRetreatRentFrom());
					}
				}
			}
		}
		
		WebElement vValiderButton = pBrowser.mFindElement(By.xpath("//*[@id=\"submit-situation-particuliere\"]"));
		if(vValiderButton != null)
		{
			if(vValiderButton.isDisplayed() && vValiderButton.isEnabled())		
			{
				vValiderButton.click();
				this.mPause(1, 3);
			}
		}
	}
	
	private void mValiderReponse(WebBrowser pBrowser)
	{
		WebElement vRecherche;
		if(PoleEmploiPreferences.mInstance().mWorkingResearchYes())
		{
			vRecherche = pBrowser.mFindElement(By.xpath(EPreferencesFields.WorkingResearchYes.mXPath()));
		}
		else
		{
			vRecherche = pBrowser.mFindElement(By.xpath(EPreferencesFields.WorkingResearchNo.mXPath()));
		}
		if(vRecherche != null && vRecherche.isDisplayed() && vRecherche.isEnabled())
		{
			vRecherche.click();
			this.mPause(1, 3);
		}
		if(PoleEmploiPreferences.mInstance().mWorkingResearchYes())
		{
			
		}
	
		WebElement vValiderButton = pBrowser.mFindElement(By.xpath("//*[@id=\"btn-valider-actu\"]"));
		if(vValiderButton != null && vValiderButton.isDisplayed() && vValiderButton.isEnabled())		
		{
			vValiderButton.click();
			this.mPause(1, 3);
		}
		if(pBrowser.mPageSource().contains("Êtes-vous d'accord pour répondre à un court sondage pour améliorer le service Actualisation ?"))
		{
			WebElement vNon = pBrowser.mFindElement(By.xpath("//*[@id=\"QID1-2-label\"]"));
			if(vNon != null && vNon.isDisplayed() && vNon.isEnabled())
			{
				vNon.click();
				this.mPause(1, 3);
			}
			WebElement vNext = pBrowser.mFindElement(By.xpath("//*[@id=\"NextButton\"]"));
			if(vNext != null && vNext.isDisplayed() && vNext.isEnabled())
			{
				vNext.click();
				this.mPause(1, 3);
			}
		}
	}
	private void mQuitter(WebBrowser pBrowser)
	{
		WebElement vQuitterButton = pBrowser.mFindElement(By.xpath("/html/body/div/div[1]/div[4]/p[1]/a/span"));
		if(vQuitterButton != null)
		{
			if(vQuitterButton.isDisplayed() && vQuitterButton.isEnabled())		
			{
				vQuitterButton.click();
				this.mPause(1, 5);
				
				WebElement vConfirmerQuitterButton = pBrowser.mFindElement(By.xpath("/html/body/div[1]/div[4]/div/div/div[3]/ul/li[2]/span/a"));
				if(vConfirmerQuitterButton != null)
				{
					if(vConfirmerQuitterButton.isDisplayed() && vConfirmerQuitterButton.isEnabled())		
					{
						vConfirmerQuitterButton.click();	
						this.mPause(1, 5);			
					}	
				}	
			}	
		}
		
		WebElement vMenu = pBrowser.mFindElement(By.id("dropdownMenu2-2"));
		if(vMenu != null)
		{
			if(vMenu.isDisplayed() && vMenu.isEnabled())		
			{
				vMenu.click();
				this.mPause(1, 5);
				WebElement vQuitterMenu = pBrowser.mFindElement(By.xpath("/html/body/header/div[2]/ul/li/div[2]/ul/li[2]/a"));
				if(vQuitterMenu != null)
				{
					if(vQuitterMenu.isDisplayed() && vQuitterMenu.isEnabled())		
					{
						vQuitterMenu.click();	
						this.mPause(1, 5);	
						
						WebElement vConfirmerQuitterMenu = pBrowser.mFindElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]"));
						if(vConfirmerQuitterMenu != null)
						{
							if(vConfirmerQuitterMenu.isDisplayed() && vConfirmerQuitterMenu.isEnabled())		
							{
								vConfirmerQuitterMenu.click();	
								this.mPause(5, 5);			
							}	
						}
					}	
				}
			}	
		}		
	}
}
