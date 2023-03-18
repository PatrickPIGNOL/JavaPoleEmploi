package ovh.pignol.JavaPoleEmploi;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ovh.pignol.JavaSelenium.Probe;

public class ApplicationGUI extends Application 
{
	private Stage aWindow;
	private Text aID;
	private TextField aIDField;
	private Text aPassword;
	private PasswordField aPasswordField;
	private Button aSave;
	private Button aLaunch;
	private Button aClose;
	
	@Override
	public void start(Stage pWindow) throws Exception 
	{
		PoleEmploiPreferences vPreferences = PoleEmploiPreferences.mInstance();
		this.aWindow = pWindow;
		this.aWindow.setTitle("Pole-Emploi Selenium Automaton");
		this.aID			= new Text("Identifiant : "); 
		this.aPassword		= new Text("Mot de passe : ");
		this.aIDField		= new TextField();	
		this.aPasswordField	= new PasswordField();		
		this.aSave			= new Button("Sauvegarder");
		this.aLaunch		= new Button("Lancer");
		this.aClose			= new Button("Fermer");
		this.mDisableGUI(true);
		this.aIDField.setText(vPreferences.mUser());
		this.aIDField.textProperty().addListener
		(
			new ChangeListener<String>() 
			{
			    @Override
			    public void changed
			    (
			    	ObservableValue<? extends String> observable, 
			    	String oldValue, 
			    	String newValue
			    ) 
			    {
			    	mDisableLaunch(false);
			    }
			}
		);
		this.aPasswordField.setText(vPreferences.mPassword());
		this.aPasswordField.textProperty().addListener
		(
			new ChangeListener<String>() 
			{
			    @Override
			    public void changed
			    (
			    	ObservableValue<? extends String> observable, 
			    	String oldValue, 
			    	String newValue
			    ) 
			    {
			    	mDisableLaunch(false);
			    }
			}
		);
		this.aIDField.setPromptText("Votre idetifiant...");
		this.aPasswordField.setPromptText("Votre mot de passe...");
		this.aID.setTranslateY(15.0);
		this.aIDField.setTranslateY(20.0);
		this.aPassword.setTranslateY(60.0);
		this.aPasswordField.setTranslateY(65.0);
		this.aSave.setTranslateY(92);
		this.aLaunch.setTranslateY(120.0);
		this.aClose.setTranslateY(150.0);
		this.aSave.setOnAction
		(
			new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent e)
				{
					mSaveOnAction(e);
				}
			}
		);
		this.aLaunch.setOnAction
		(
			new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent e)
				{
					mLaunchOnAction(e);
				}
			}
		);
		this.aClose.setOnAction
		(
			new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent e)
				{
					mCloseOnAction(e);
				}
			}
		);
		this.mDisableGUI(false);
		Group vRoot = new Group();
		this.aWindow.setScene(new Scene(vRoot));
		vRoot.getChildren().addAll(this.aID, this.aIDField, this.aPassword, this.aPasswordField, this.aSave, this.aLaunch, this.aClose);
		this.aWindow.show();
	}
	
	public void mSaveOnAction(ActionEvent e)
	{
		PoleEmploiPreferences vPreferences = PoleEmploiPreferences.mInstance();
		vPreferences.mUser(this.aIDField.getText());
		vPreferences.mPassword(this.aPasswordField.getText());			
		vPreferences.mFlush();
	}
	
	public void mLaunchOnAction(ActionEvent e)
	{
		try(Probe vPoleEmploi = new PoleEmploi())
		{
			vPoleEmploi.mStart();
			vPoleEmploi.mJoin();
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}
	
	public void mDisableGUI(boolean pDisable)
	{
		this.aIDField.setDisable(pDisable);
		this.aPasswordField.setDisable(pDisable);
		this.aSave.setDisable(pDisable);
		this.mDisableLaunch(pDisable);
		this.aClose.setDisable(pDisable);
	}
	
	public void mDisableLaunch(boolean pDisable)
	{
		if(this.aIDField.getText().trim().isEmpty() || this.aPasswordField.getText().isEmpty())
		{
			this.aLaunch.setDisable(true);
		}
		else
		{
			this.aLaunch.setDisable(pDisable);
		}
	}
	
	public void mCloseOnAction(ActionEvent e)
	{
		this.aWindow.close();
	}
}
