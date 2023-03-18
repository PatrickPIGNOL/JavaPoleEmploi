package ovh.pignol.JavaPoleEmploi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

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
				if(vCloseButton != null)
				{
					if(vCloseButton.isDisplayed() && vCloseButton.isEnabled())
					{
						vCloseButton.click();
						this.mPause(1, 5);
					}
				}
			}
			WebElement vLEmission = pBrowser.mFindElement(By.tagName("ngb-modal-window"));
			if(vLEmission != null)
			{
				WebElement vCloseButton = pBrowser.mFindElement(By.xpath("/html/body/ngb-modal-window/div/div/app-popin-pub/div/div[1]/button"));
				if(vCloseButton != null)
				{
					if(vCloseButton.isDisplayed() && vCloseButton.isEnabled())
					{
						vCloseButton.click();
						this.mPause(1, 5);
					}
				}
			}
			WebElement vCookies = pBrowser.mFindElement(By.id("tc-privacy-wrapper"));
			if(vCookies != null)
			{
				WebElement vCloseButton = pBrowser.mFindElement(By.id("footer_tc_privacy_button_2"));
				if(vCloseButton != null)
				{
					if(vCloseButton.isDisplayed() && vCloseButton.isEnabled())
					{
						vCloseButton.click();
						this.mPause(1, 5);
					}
				}
			}

			this.mPause(3, 5);
			
			WebElement vConnectButton = pBrowser.mFindElement(By.xpath("/html/body/app-root/app-header/header/div/ul/li/div/button"));//By.id("dropdownMenu2"));
			if(vConnectButton != null)
			{
				if(vConnectButton.isDisplayed()&& vConnectButton.isEnabled())
				{
					vConnectButton.click();
					this.mPause(1, 5);
					WebElement vCandidatButton = pBrowser.mFindElement(By.className("menu-link-candidat"));
					if(vCandidatButton != null)
					{
						if(vCandidatButton.isDisplayed() && vCandidatButton.isEnabled())
						{
							vCandidatButton.click();
							this.mPause(10, 1);
						}
					}
				}
			}
			WebElement vIdentifiant = pBrowser.mFindElement(By.id("identifiant"));
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
							WebElement vPassword = pBrowser.mFindElement(By.id("password"));
							if(vPassword != null)
							{
								if(vPassword.isDisplayed() && vPassword.isEnabled())
								{
									vPassword.sendKeys(PoleEmploiPreferences.mInstance().mPassword());
									WebElement vSubmitButton2 = pBrowser.mFindElement(By.id("submit"));
									if(vSubmitButton2 != null)
									{
										if(vSubmitButton2.isDisplayed() && vSubmitButton2.isEnabled())
										{
											vSubmitButton2.click();
											this.mPause(10, 1);											
										}
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
		WebElement vActualiseLink = pBrowser.mFindElement(By.xpath("/html/body/app-root/ng-component/cl-layout/main/app-accueil/div/div/div/div/div[2]/div/div[1]/pn-menu-navigation/div[2]/div/ul/li[1]/div/button"));
		if(vActualiseLink != null)
		{
			if(vActualiseLink.isDisplayed() && vActualiseLink.isEnabled())
			{
				vActualiseLink.click();
				this.mPause(1,5);
				WebElement vActualiseButton = pBrowser.mFindElement(By.xpath("/html/body/app-root/ng-component/cl-layout/main/app-accueil/div/div/div/div/div[2]/div/div[1]/pn-menu-navigation/div[2]/div/ul/li[1]/div/div/div/ul/li[1]/a"));
				if(vActualiseButton != null)
				{
					if(vActualiseButton.isDisplayed() && vActualiseButton.isEnabled())
					{
						vActualiseButton.click();
						this.mPause(10, 1);
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
					this.mPause(10, 1);
				}
			}
		}		
		
		if(pBrowser.mPageSource().contains("Vous avez d��j�� d��clar�� votre situation pour cette p��riode"))
		{
			WebElement vModifierButton = pBrowser.mFindElement(By.xpath("/html/body/div/div[2]/div/div[1]/div[2]/div/div[1]/form/div/div[2]/ul/li[3]/span/button"));
			if(vModifierButton != null)
			{
				if(vModifierButton.isDisplayed() && vModifierButton.isEnabled())
				{
					vModifierButton.click();
					this.mPause(10, 1);
				}
			}
		}
		
		WebElement vFormation = pBrowser.mFindElement(By.id("formationNon"));//[@id="formationOui"]
		if(vFormation != null)
		{
			if(vFormation.isDisplayed() && vFormation.isEnabled())		
			{
				vFormation.click();
				this.mPause(1, 5);
				WebElement vValidateButton = pBrowser.mFindElement(By.xpath("/html/body/div/div[2]/div/div[1]/div[2]/div/div[1]/form/div/div[2]/ul/li[3]/span/button"));
				if(vValidateButton != null)
				{
					if(vValidateButton.isDisplayed() && vValidateButton.isEnabled())		
					{
						vValidateButton.click();
						this.mPause(1, 5);
					}
				}
			}
		}
	}
	
	private void mActualisePage2(WebBrowser pBrowser)
	{
		//"Avez-vous travaillé ou exercé une activité non salariée ?"
		//"Oui"[@id="blocTravail-open"]
		//"Non"[@id="blocTravail-close"]
		//[@id="nbHeuresTrav"]"Heures travaillées dans le mois [____] heures"
		//[@id="montSalaire"] "Montant total de votre ou vos salaires bruts réels ou estimés [____]€
		WebElement vTravailNon = pBrowser.mFindElement(By.id("blocTravail-close"));		
		if(vTravailNon != null)
		{
			if(vTravailNon.isDisplayed() && vTravailNon.isEnabled())		
			{
				vTravailNon.click();
				this.mPause(1, 3);
			}
		}
		
		//"Avez-vous été en stage ?"
		//"Oui"[@id="blocStage-open"]
		//"Non"[@id="blocStage-close"]
		//"Du "[@id="dateDebutStage"] JJ/MM/AAAA
		//"au "[@id="dateFinStage"] JJ/MM/AAAA		
		WebElement vStageNon = pBrowser.mFindElement(By.id("blocStage-close"));
		if(vStageNon != null)
		{
			if(vStageNon.isDisplayed() && vStageNon.isEnabled())		
			{
				vStageNon.click();
				this.mPause(1, 3);
			}
		}
		
		//"Avez-vous été en arrêt maladie ?"
		//"Oui"[@id="blocMaladie-open"]
		//"Non"[@id="blocMaladie-close"]
		//"Du"[@id="dateDebutMaladie"] JJ/MM/AAAA
		//"au"[@id="dateFinMaladie"] JJ/MM/AAAA
		WebElement vMaladieNon = pBrowser.mFindElement(By.id("blocMaladie-close"));
		if(vMaladieNon != null)
		{
			if(vMaladieNon.isDisplayed() && vMaladieNon.isEnabled())		
			{
				vMaladieNon.click();
				this.mPause(1, 3);
			}
		}
		
		//"Percevez-vous une nouvelle pension retraite ?"
		//"Oui"[@id="blocRetraite-open
		//"Non"[@id="blocRetraite-close
		//"Depuis le"[@id="dateRetraite"] JJ/MM/AAAA
		WebElement vRetraiteNon = pBrowser.mFindElement(By.id("blocRetraite-close"));
		if(vRetraiteNon != null)
		{
			if(vRetraiteNon.isDisplayed() && vRetraiteNon.isEnabled())		
			{
				vRetraiteNon.click();
				this.mPause(1, 3);
			}
		}
		
		//"Percevez-vous une nouvelle pension d'invalidité de 2ème ou 3ème catégorie ?"
		//"Oui"[@id="blocInvalidite-open"]
		//"Non"[@id="blocInvalidite-close"]
		//"Depuis le"[@id="dateInvalidite"] JJ/MM/AAAA		
		WebElement vInvaliditeNon = pBrowser.mFindElement(By.id("blocInvalidite-close"));
		if(vInvaliditeNon != null)
		{
			if(vInvaliditeNon.isDisplayed() && vInvaliditeNon.isEnabled())		
			{
				vInvaliditeNon.click();
				this.mPause(1, 3);
			}
		}
		//"Etes-vous toujours à la recherche d'un emploi ?"
		//"Oui"[@id="blocRecherche-close"]
		//"Non"[@id="blocRecherche-open"]
		//"Vous n'êtes plus à la recherche d'un emploi depuis le"[@id="dateFinRech"]
		//"Pour quel motif ?"
		//[@id="motifFinRechReprise"]"Reprise du travail"
		//[@id="motifFinRechRetraite"]"Retraite"
		//[@id="motifFinRechAutre"]"Autre
		WebElement vRechercheOui = pBrowser.mFindElement(By.id("blocRecherche-close"));
		if(vRechercheOui != null)
		{
			if(vRechercheOui.isDisplayed() && vRechercheOui.isEnabled())		
			{
				vRechercheOui.click();
				this.mPause(1, 3);
			}
		}
		
		
		WebElement vValiderButton = pBrowser.mFindElement(By.xpath("/html/body/div/div[2]/div/div[1]/div[2]/div/div[1]/form/div/div[3]/ul/li[3]/span/button"));
		if(vValiderButton != null)
		{
			if(vValiderButton.isDisplayed() && vValiderButton.isEnabled())		
			{
				vValiderButton.click();
				this.mPause(10, 1);
			}
		}
	}
	
	private void mValiderReponse(WebBrowser pBrowser)
	{
		WebElement vValiderButton = pBrowser.mFindElement(By.xpath("/html/body/div/div[2]/div/div[1]/div[2]/div/div[1]/form/div/div[2]/ul/li[3]/span/button"));
		if(vValiderButton != null)
		{
			if(vValiderButton.isDisplayed() && vValiderButton.isEnabled())		
			{
				vValiderButton.click();
				this.mPause(10, 1);
			}		
		}
		//TODO: Ajouter le téléchargement du justificatif
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
