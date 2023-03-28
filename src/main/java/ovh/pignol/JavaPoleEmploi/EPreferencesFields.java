package ovh.pignol.JavaPoleEmploi;

public enum EPreferencesFields 
{
	User						("User", "", "//*[@id=\"identifiant\"]"),
	Password					("Password", "", "//*[@id=\"password\"]"),
	WorkedYes					("WorkedYes", "False", "//*[@id=\"label-activite-oui\"]"),
	WorkedNo					("WorkedNo", "True", "//*[@id=\"form\"]/app-activites/form/app-saisie-activites/div/fieldset/div/ul/li[2]/label"),
	WorkedForSociety			("WorkedForSociety", "False", "//*[@id=\"activite-type-salarie\"]"),
	WorkedMySociety				("WorkedMySociety", "False", "//*[@id=\"activite-type-non-salarie\"]"),
	WorkedSociety				("WorkedSociety", "", "//*[@id=\"nom\"]"),	
	WorkHours					("WorkHours","0", "//*[@id=\"heures-travaille\"]"),
	SalaryAmount				("SalaryAmount","0", "//*[@id=\"montant\"]"),
	WorkFrom					("WorkFrom","0: null", "//*[@id=\"periode-debut\"]"),
	WorkTo						("WorkTo","0: null","//*[@id=\"periode-fin\"]"),
	StageYes					("StageYes","False","//*[@id=\"sitPartiForm\"]/div[1]/div[1]/app-question-chapeau/div/fieldset/div/ul/li[1]/label"),
	StageNo						("StageNo","True","//*[@id=\"sitPartiForm\"]/div[1]/div[1]/app-question-chapeau/div/fieldset/div/ul/li[2]/label"),
	StageName					("StageName", "", "//*[@id=\"name-formation\"]"),
	StageFrom					("StageFrom","","//*[@id=\"formation-date-debut\"]"),
	StageTo						("StageTo","","//*[@id=\"formation-date-fin\"]"),
	DeaceaseBreakYes			("DeaceaseBreakYes","False","//*[@id=\"body-PAM\"]/app-question-chapeau/div/fieldset/div/ul/li[1]/label"),
	DeaceaseBreakNo				("DeaceaseBreakNo","True","//*[@id=\"body-PAM\"]/app-question-chapeau/div/fieldset/div/ul/li[2]/label"),
	DeaceaseBreakFrom			("DeaceaseBreakFrom","","//*[@id=\"pam-date-debut\"]"),
	DeaceaseBreakTo				("DeaceaseBreakTo","","//*[@id=\"pam-date-fin\"]"),
	NewRetreatRentYes			("NewRetreatRentYes","False","//*[@id=\"sitPartiForm\"]/div[1]/div[3]/app-question-chapeau/div/fieldset/div/ul/li[1]/label"),
	NewRetreatRentNo			("NewRetreatRentNo","True","//*[@id=\"sitPartiForm\"]/div[1]/div[3]/app-question-chapeau/div/fieldset/div/ul/li[2]/label"),	
	NewRetreatRentFrom			("NewRetreatRentFrom","","//*[@id=\\\"date-pensionRetraite\\\"]"),
	NewInvalidRent				("NewInvalidRent","False","//*[@id=\"label-checkbox-pensionInvalidite\"]"),
	NewRetreatRent				("NewRetreatRent","False","//*[@id=\"label-checkbox-pensionRetraite\"]"),	
	NewInvalidRentFrom			("NewInvalidRentFrom","","//*[@id=\\\"date-pensionInvalidite\\\"]"),
	WorkingResearchYes			("WorkingResearchYes","True","//*[@id=\"question-maintien-inscription\"]/app-question-chapeau/div/fieldset/div/ul/li[1]/label"),
	WorkingResearchNo			("WorkingResearchNo","False","//*[@id=\"question-maintien-inscription\"]/app-question-chapeau/div/fieldset/div/ul/li[2]/label"),
	WorkingResearchNoFrom		("WorkingResearchNoFrom","",""),
	WorkingResearchNoWorking	("WorkingResearchNoWorking","False",""),
	WorkingResearchNoRetreat	("WorkingResearchNoRetreat","False",""),
	WorkingResearchNoOther		("WorkingResearchNoOther","False","")
	;
	
	private String aFieldName;
	private String aDefaultValue;
	private String aXPath;
	private EPreferencesFields(String pFieldName, String pDefaultValue, String pXPath) 
	{
		this.aFieldName = pFieldName;
		this.aDefaultValue = pDefaultValue;
		this.aXPath = pXPath;
	}
	public String mFieldName()
	{
		return this.aFieldName;
	}
	public String mDefaultValue()
	{
		return this.aDefaultValue;
	}
	public String mXPath()
	{
		return this.aXPath;
	}
}
