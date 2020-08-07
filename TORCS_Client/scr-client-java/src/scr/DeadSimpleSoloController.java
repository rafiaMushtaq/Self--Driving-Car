package scr;
import java.io.FileOutputStream;
import java.io.PrintWriter;



/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: Mar 4, 2008
 * Time: 4:59:21 PM

 */
public class DeadSimpleSoloController extends Controller {

    final double targetSpeed = 15;


    public Action control(SensorModel sensorModel) {
        Action action = new Action ();
        if (sensorModel.getSpeed () < targetSpeed) {
            action.accelerate = 1;
        }
        if (sensorModel.getAngleToTrackAxis() < 0) {
            action.steering = -0.1;
        }
        else {
            action.steering = 0.1;
        }
        action.gear = 1;
		
		
		
		
		//////////////////////////////////////////////////////Sensor code will be written here 
	/*	
	 saveRecord( String.valueOf(sensorModel.getSpeed()),  String.valueOf(sensorModel.getAngleToTrackAxis()),
	  String.valueOf(sensorModel.getTrackPosition()),  Integer.toString(sensorModel.getGear()),
	  Integer.toString(sensorModel.getRacePosition()),
	  String.valueOf(sensorModel.getLateralSpeed()),
	  String.valueOf(sensorModel.getCurrentLapTime()),  String.valueOf(sensorModel.getDamage()),
	  String.valueOf(sensorModel.getDistanceFromStartLine()),  String.valueOf(sensorModel.getDistanceRaced()), 
	  String.valueOf(sensorModel.getFuelLevel()) 
	 ,  String.valueOf(sensorModel.getLastLapTime()),
	  String.valueOf(sensorModel.getRPM()),  String.valueOf(sensorModel.getZSpeed()), String.valueOf(sensorModel.getZ()), sensorModel.getMessage());
		*/
		
		
		/////////////////////////////////////////////////////////////
        return action;
    }
	
	 public static void saveRecord(String getSpeed, String getAngleToTrackAxis,
	 String getTrackPosition, String getGear,String getRacePosition,String getLateralSpeed,String getCurrentLapTime, String getDamage ,
	 String getDistanceFromStartLine, String getDistanceRaced, String getFuelLevel , String getLastLapTime,
	 String getRPM, String getZSpeed,String getZ,String getMessage)
	{
		try
		{
            FileOutputStream fos= new FileOutputStream("StateFile.csv",true);
            PrintWriter pw =new PrintWriter(fos);
            pw.println(getSpeed+","+getAngleToTrackAxis+","+getTrackPosition+","+getGear+","+getRacePosition+","
			+getLateralSpeed+","+getCurrentLapTime+","+getDamage+","+getDistanceFromStartLine+","+getDistanceRaced+","
			+getFuelLevel+","+getLastLapTime+","+getRPM+","+getZSpeed+","+getZ+","+getMessage);
            pw.close();
		}
		catch(Exception E)
		{
			
		}
	}

    public void reset() {
		System.out.println("Restarting the race!");
		
	}

	public void shutdown() {
		System.out.println("Bye bye!");		
	}
}
