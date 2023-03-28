package ovh.pignol.JavaPoleEmploi;

import java.util.prefs.Preferences;

public class PoleEmploiPreferences
{
	private static class PreferencesHolder
	{
		private static PoleEmploiPreferences sPreferences = new PoleEmploiPreferences();
		public static PoleEmploiPreferences mInstance()
		{
			return PreferencesHolder.sPreferences;
		}
	}
	
	public static PoleEmploiPreferences mInstance()
	{
		return PreferencesHolder.mInstance();
	}
		
	private Preferences aPreference;
	
	private String aUser;
	private String aPassword;
	private String aWorkedYes;
	private String aWorkedNo;
	private String aWorkedForSociety;
	private String aWorkedMySociety;
	private String aWorkedSociety;
	private String aWorkHours;
	private String aSalaryAmount;
	private String aWorkFrom;
	private String aWorkTo;
	private String aStageYes;
	private String aStageNo;
	private String aStageName;
	private String aStageFrom;
	private String aStageTo;
	private String aDeaceaseBreakYes;
	private String aDeaceaseBreakNo;
	private String aDeaceaseBreakFrom;
	private String aDeaceaseBreakTo;
	private String aNewRetreatRentYes;
	private String aNewRetreatRentNo;	
	private String aNewRetreatRentFrom;
	private String aNewRetreatRent;
	private String aNewInvalidRent;	
	private String aNewInvalidRentFrom;
	private String aWorkingResearchYes;
	private String aWorkingResearchNo;
	private String aWorkingResearchNoFrom;
	private String aWorkingResearchNoWorking;
	private String aWorkingResearchNoRetreat;
	private String aWorkingResearchNoOther;		
	
	private PoleEmploiPreferences()
	{
		this.aPreference = Preferences.userNodeForPackage(this.getClass());
		this.aUser 						= this.aPreference.get(EPreferencesFields.User						.mFieldName(), EPreferencesFields.User						.mDefaultValue());
		this.aPassword 					= this.aPreference.get(EPreferencesFields.Password					.mFieldName(), EPreferencesFields.Password					.mDefaultValue());
		this.aWorkedYes					= this.aPreference.get(EPreferencesFields.WorkedYes					.mFieldName(), EPreferencesFields.WorkedYes					.mDefaultValue());                 
		this.aWorkedNo                  = this.aPreference.get(EPreferencesFields.WorkedNo					.mFieldName(), EPreferencesFields.WorkedNo					.mDefaultValue());
		this.aWorkedForSociety			= this.aPreference.get(EPreferencesFields.WorkedForSociety			.mFieldName(), EPreferencesFields.WorkedForSociety			.mDefaultValue());
		this.aWorkedMySociety			= this.aPreference.get(EPreferencesFields.WorkedMySociety			.mFieldName(), EPreferencesFields.WorkedMySociety			.mDefaultValue());
		this.aWorkedSociety				= this.aPreference.get(EPreferencesFields.WorkedSociety				.mFieldName(), EPreferencesFields.WorkedSociety				.mDefaultValue());
		this.aWorkHours                 = this.aPreference.get(EPreferencesFields.WorkHours					.mFieldName(), EPreferencesFields.WorkHours					.mDefaultValue());
		this.aSalaryAmount              = this.aPreference.get(EPreferencesFields.SalaryAmount				.mFieldName(), EPreferencesFields.SalaryAmount				.mDefaultValue());
		this.aWorkFrom					= this.aPreference.get(EPreferencesFields.WorkFrom					.mFieldName(), EPreferencesFields.WorkFrom					.mDefaultValue());
		this.aWorkTo					= this.aPreference.get(EPreferencesFields.WorkTo					.mFieldName(), EPreferencesFields.WorkTo					.mDefaultValue());
		this.aStageYes                  = this.aPreference.get(EPreferencesFields.StageYes					.mFieldName(), EPreferencesFields.StageYes					.mDefaultValue());
		this.aStageNo                   = this.aPreference.get(EPreferencesFields.StageNo					.mFieldName(), EPreferencesFields.StageNo					.mDefaultValue());
		this.aStageName					= this.aPreference.get(EPreferencesFields.StageName					.mFieldName(), EPreferencesFields.StageName					.mDefaultValue());
		this.aStageFrom                 = this.aPreference.get(EPreferencesFields.StageFrom					.mFieldName(), EPreferencesFields.StageFrom					.mDefaultValue());
		this.aStageTo                   = this.aPreference.get(EPreferencesFields.StageTo					.mFieldName(), EPreferencesFields.StageTo					.mDefaultValue());
		this.aDeaceaseBreakYes          = this.aPreference.get(EPreferencesFields.DeaceaseBreakYes			.mFieldName(), EPreferencesFields.DeaceaseBreakYes			.mDefaultValue());
		this.aDeaceaseBreakNo           = this.aPreference.get(EPreferencesFields.DeaceaseBreakNo			.mFieldName(), EPreferencesFields.DeaceaseBreakNo			.mDefaultValue());
		this.aDeaceaseBreakFrom         = this.aPreference.get(EPreferencesFields.DeaceaseBreakFrom			.mFieldName(), EPreferencesFields.DeaceaseBreakFrom			.mDefaultValue());
		this.aDeaceaseBreakTo           = this.aPreference.get(EPreferencesFields.DeaceaseBreakTo			.mFieldName(), EPreferencesFields.DeaceaseBreakTo			.mDefaultValue());
		this.aNewRetreatRentYes         = this.aPreference.get(EPreferencesFields.NewRetreatRentYes			.mFieldName(), EPreferencesFields.NewRetreatRentYes			.mDefaultValue());
		this.aNewRetreatRentNo	        = this.aPreference.get(EPreferencesFields.NewRetreatRentNo			.mFieldName(), EPreferencesFields.NewRetreatRentNo			.mDefaultValue());
		this.aNewRetreatRentFrom        = this.aPreference.get(EPreferencesFields.NewRetreatRentFrom		.mFieldName(), EPreferencesFields.NewRetreatRentFrom		.mDefaultValue());
		this.aNewRetreatRent         	= this.aPreference.get(EPreferencesFields.NewRetreatRent			.mFieldName(), EPreferencesFields.NewRetreatRent			.mDefaultValue());
		this.aNewInvalidRent	        = this.aPreference.get(EPreferencesFields.NewInvalidRent			.mFieldName(), EPreferencesFields.NewInvalidRent			.mDefaultValue());
		this.aNewInvalidRentFrom        = this.aPreference.get(EPreferencesFields.NewInvalidRentFrom		.mFieldName(), EPreferencesFields.NewInvalidRentFrom		.mDefaultValue());
		this.aWorkingResearchYes        = this.aPreference.get(EPreferencesFields.WorkingResearchYes		.mFieldName(), EPreferencesFields.WorkingResearchYes		.mDefaultValue());
		this.aWorkingResearchNo         = this.aPreference.get(EPreferencesFields.WorkingResearchNo			.mFieldName(), EPreferencesFields.WorkingResearchNo			.mDefaultValue());
		this.aWorkingResearchNoFrom     = this.aPreference.get(EPreferencesFields.WorkingResearchNoFrom		.mFieldName(), EPreferencesFields.WorkingResearchNoFrom		.mDefaultValue());
		this.aWorkingResearchNoWorking  = this.aPreference.get(EPreferencesFields.WorkingResearchNoWorking	.mFieldName(), EPreferencesFields.WorkingResearchNoWorking	.mDefaultValue());
		this.aWorkingResearchNoRetreat  = this.aPreference.get(EPreferencesFields.WorkingResearchNoRetreat	.mFieldName(), EPreferencesFields.WorkingResearchNoRetreat	.mDefaultValue());
		this.aWorkingResearchNoOther	= this.aPreference.get(EPreferencesFields.WorkingResearchNoOther	.mFieldName(), EPreferencesFields.WorkingResearchNoOther	.mDefaultValue());
	}
	
	public void mFlush()
	{
		try
		{
			this.aPreference.flush();
		}
		catch(Exception e)
		{
			e.printStackTrace(System.err);
		}
	}
	
	public String mUser()
	{
		return this.aUser;
	}
	
	public void mUser(String pUser)
	{
		this.aPreference.put(EPreferencesFields.User.mFieldName(), this.aUser = pUser);
	}
	
	public String	mPassword					(){return 						this.aPassword;					  } public void mPassword					(String		pPassword)	{this.aPreference.put(EPreferencesFields.Password.mFieldName(), this.aPassword = pPassword);												}	
	public Boolean	mWorkedYes					(){return Boolean.parseBoolean(	this.aWorkedYes					);} public void	mWorkedYes					(Boolean	pValue)		{this.aPreference.put(EPreferencesFields.WorkedYes					.mFieldName(), this.aWorkedYes					 = pValue.toString());	}
	public Boolean	mWorkedNo                   (){return Boolean.parseBoolean(	this.aWorkedNo					);}	public void	mWorkedNo                   (Boolean	pValue)		{this.aPreference.put(EPreferencesFields.WorkedNo					.mFieldName(), this.aWorkedNo					 = pValue.toString());	}
	public Boolean  mWorkedForSociety			(){return Boolean.parseBoolean( this.aWorkedForSociety			);} public void mWorkedForSociety			(Boolean	pValue)		{this.aPreference.put(EPreferencesFields.WorkedForSociety			.mFieldName(), this.aWorkedForSociety            = pValue.toString());	}  
	public Boolean  mWorkedMySociety	 		(){return Boolean.parseBoolean( this.aWorkedMySociety			);} public void mWorkedMySociety			(Boolean	pValue)		{this.aPreference.put(EPreferencesFields.WorkedMySociety 			.mFieldName(), this.aWorkedMySociety             = pValue.toString());	}  
	public String   mWorkedSociety		  		(){return 						this.aWorkedSociety				 ;} public void mWorkedSociety				(String 	pValue)		{this.aPreference.put(EPreferencesFields.WorkedSociety   			.mFieldName(), this.aWorkedSociety               = pValue			);	}  
	public Integer	mWorkHours                  (){return Integer.parseInt(		this.aWorkHours					);}	public void	mWorkHours                  (Integer	pValue)		{this.aPreference.put(EPreferencesFields.WorkHours					.mFieldName(), this.aWorkHours					 = pValue.toString());	}
	public Integer	mSalaryAmount               (){return Integer.parseInt(		this.aSalaryAmount				);}	public void	mSalaryAmount               (Integer	pValue)		{this.aPreference.put(EPreferencesFields.SalaryAmount				.mFieldName(), this.aSalaryAmount				 = pValue.toString());	}
	public String   mWorkFrom					(){return						this.aWorkFrom					 ;}	public void mWorkFrom					(String		pValue)		{this.aPreference.put(EPreferencesFields.WorkFrom					.mFieldName(), this.aWorkFrom					 = pValue			);	}
	public String   mWorkTo  					(){return						this.aWorkTo  					 ;}	public void mWorkTo  					(String		pValue)		{this.aPreference.put(EPreferencesFields.WorkTo  					.mFieldName(), this.aWorkTo  					 = pValue			);	}
	public Boolean	mStageYes                   (){return Boolean.parseBoolean(	this.aStageYes					);}	public void	mStageYes                   (Boolean	pValue)		{this.aPreference.put(EPreferencesFields.StageYes					.mFieldName(), this.aStageYes					 = pValue.toString());	}
	public Boolean	mStageNo                    (){return Boolean.parseBoolean(	this.aStageNo					);}	public void	mStageNo                    (Boolean	pValue)		{this.aPreference.put(EPreferencesFields.StageNo					.mFieldName(), this.aStageNo					 = pValue.toString());	}
	public String	mStageName					(){return 						this.aStageName					 ;}	public void	mStageName                  (String		pValue)		{this.aPreference.put(EPreferencesFields.StageName					.mFieldName(), this.aStageName					 = pValue			);	}
	public String	mStageFrom                  (){return 						this.aStageFrom					 ;}	public void	mStageFrom                  (String		pValue)		{this.aPreference.put(EPreferencesFields.StageFrom					.mFieldName(), this.aStageFrom					 = pValue			);	}
	public String	mStageTo                    (){return 						this.aStageTo					 ;}	public void	mStageTo                    (String		pValue)		{this.aPreference.put(EPreferencesFields.StageTo					.mFieldName(), this.aStageTo					 = pValue			);	}
	public Boolean	mDeaceaseBreakYes           (){return Boolean.parseBoolean(	this.aDeaceaseBreakYes			);}	public void	mDeaceaseBreakYes           (Boolean	pValue)		{this.aPreference.put(EPreferencesFields.DeaceaseBreakYes			.mFieldName(), this.aDeaceaseBreakYes			 = pValue.toString());	}
	public Boolean	mDeaceaseBreakNo            (){return Boolean.parseBoolean(	this.aDeaceaseBreakNo			);}	public void	mDeaceaseBreakNo            (Boolean	pValue)		{this.aPreference.put(EPreferencesFields.DeaceaseBreakNo			.mFieldName(), this.aDeaceaseBreakNo			 = pValue.toString());	}
	public String	mDeaceaseBreakFrom          (){return 						this.aDeaceaseBreakFrom			 ;}	public void	mDeaceaseBreakFrom          (String		pValue)		{this.aPreference.put(EPreferencesFields.DeaceaseBreakFrom			.mFieldName(), this.aDeaceaseBreakFrom			 = pValue			);	}
	public String	mDeaceaseBreakTo            (){return 						this.aDeaceaseBreakTo			 ;}	public void	mDeaceaseBreakTo            (String		pValue)		{this.aPreference.put(EPreferencesFields.DeaceaseBreakTo			.mFieldName(), this.aDeaceaseBreakTo			 = pValue			);	}
	public Boolean	mNewRetreatRentYes          (){return Boolean.parseBoolean(	this.aNewRetreatRentYes			);}	public void	mNewRetreatRentYes          (Boolean	pValue)		{this.aPreference.put(EPreferencesFields.NewRetreatRentYes			.mFieldName(), this.aNewRetreatRentYes			 = pValue.toString());	}
	public Boolean	mNewRetreatRentNo           (){return Boolean.parseBoolean(	this.aNewRetreatRentNo			);}	public void	mNewRetreatRentNo           (Boolean	pValue)		{this.aPreference.put(EPreferencesFields.NewRetreatRentNo			.mFieldName(), this.aNewRetreatRentNo			 = pValue.toString());	}
	public String	mNewRetreatRentFrom         (){return 						this.aNewRetreatRentFrom		 ;}	public void	mNewRetreatRentFrom         (String		pValue)		{this.aPreference.put(EPreferencesFields.NewRetreatRentFrom			.mFieldName(), this.aNewRetreatRentFrom			 = pValue			);	}
	public Boolean	mNewRetreatRent		        (){return Boolean.parseBoolean(	this.aNewRetreatRent			);}	public void	mNewRetreatRent		        (Boolean	pValue)		{this.aPreference.put(EPreferencesFields.NewRetreatRent				.mFieldName(), this.aNewRetreatRent			 	 = pValue.toString());	}
	public Boolean	mNewInvalidRent	            (){return Boolean.parseBoolean(	this.aNewInvalidRent			);}	public void	mNewInvalidRent          	(Boolean	pValue)		{this.aPreference.put(EPreferencesFields.NewInvalidRent				.mFieldName(), this.aNewInvalidRent			 	 = pValue.toString());	}
	public String	mNewInvalidRentFrom         (){return 						this.aNewInvalidRentFrom		 ;}	public void	mNewInvalidRentFrom         (String		pValue)		{this.aPreference.put(EPreferencesFields.NewInvalidRentFrom			.mFieldName(), this.aNewInvalidRentFrom			 = pValue			);	}
	public Boolean	mWorkingResearchYes         (){return Boolean.parseBoolean(	this.aWorkingResearchYes		);}	public void	mWorkingResearchYes         (Boolean	pValue)		{this.aPreference.put(EPreferencesFields.WorkingResearchYes			.mFieldName(), this.aWorkingResearchYes		 	 = pValue.toString());	}
	public Boolean	mWorkingResearchNo          (){return Boolean.parseBoolean(	this.aWorkingResearchNo			);}	public void	mWorkingResearchNo          (Boolean	pValue)		{this.aPreference.put(EPreferencesFields.WorkingResearchNo			.mFieldName(), this.aWorkingResearchNo			 = pValue.toString());	}
	public String	mWorkingResearchNoFrom      (){return 						this.aWorkingResearchNoFrom		 ;}	public void	mWorkingResearchNoFrom      (String		pValue)		{this.aPreference.put(EPreferencesFields.WorkingResearchNoFrom		.mFieldName(), this.aWorkingResearchNoFrom		 = pValue			);	}
	public Boolean	mWorkingResearchNoWorking   (){return Boolean.parseBoolean(	this.aWorkingResearchNoWorking	);}	public void	mWorkingResearchNoWorking   (Boolean	pValue)		{this.aPreference.put(EPreferencesFields.WorkingResearchNoWorking	.mFieldName(), this.aWorkingResearchNoWorking	 = pValue.toString());	}
	public Boolean	mWorkingResearchNoRetreat   (){return Boolean.parseBoolean(	this.aWorkingResearchNoRetreat	);}	public void	mWorkingResearchNoRetreat   (Boolean	pValue)		{this.aPreference.put(EPreferencesFields.WorkingResearchNoRetreat	.mFieldName(), this.aWorkingResearchNoRetreat	 = pValue.toString());	}
	public Boolean	mWorkingResearchNoOther		(){return Boolean.parseBoolean(	this.aWorkingResearchNoOther	);}	public void	mWorkingResearchNoOther		(Boolean	pValue)		{this.aPreference.put(EPreferencesFields.WorkingResearchNoOther		.mFieldName(), this.aWorkingResearchNoOther	 	 = pValue.toString());	}
	
}