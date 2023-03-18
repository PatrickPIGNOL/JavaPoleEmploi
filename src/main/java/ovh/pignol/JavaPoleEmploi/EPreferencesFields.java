package ovh.pignol.JavaPoleEmploi;

public enum EPreferencesFields 
{
	User						("User",""),
	Password					("Password",""),
	WorkedYes					("WorkedYes","False"),
	WorkedNo					("WorkedNo","True"),
	WorkHours					("WorkHours","0"),
	SalaryAmount				("SalaryAmount","0"),
	StageYes					("StageYes","False"),
	StageNo						("StageNo","True"),
	StageFrom					("StageFrom",""),
	StageTo						("StageTo",""),
	DeaceaseBreakYes			("DeaceaseBreakYes","False"),
	DeaceaseBreakNo				("DeaceaseBreakNo","True"),
	DeaceaseBreakFrom			("DeaceaseBreakFrom",""),
	DeaceaseBreakTo				("DeaceaseBreakTo",""),
	NewRetreatRentYes			("NewRetreatRentYes","False"),
	NewRetreatRentNo			("NewRetreatRentNo","True"),	
	NewRetreatRentFrom			("NewRetreatRentFrom",""),
	NewInvalidRentYes			("NewInvalidRentYes","False"),
	NewInvalidRentNo			("NewInvalidRentNo","True"),	
	NewInvalidRentFrom			("NewInvalidRentFrom",""),
	WorkingResearchYes			("WorkingResearchYes","True"),
	WorkingResearchNo			("WorkingResearchNo","False"),
	WorkingResearchNoFrom		("WorkingResearchNoFrom",""),
	WorkingResearchNoWorking	("WorkingResearchNoWorking","False"),
	WorkingResearchNoRetreat	("WorkingResearchNoRetreat","False"),
	WorkingResearchNoOther		("WorkingResearchNoOther","False")
	;
	
	private String aFieldName;
	private String aDefaultValue;
	private EPreferencesFields(String pFieldName, String pDefaultValue) 
	{
		this.aFieldName = pFieldName;
		this.aDefaultValue = pDefaultValue;
	}
	public String mFieldName()
	{
		return this.aFieldName;
	}
	public String mDefaultValue()
	{
		return this.aDefaultValue;
	}
}
