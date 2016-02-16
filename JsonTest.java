import org.json.simple.JSONObject;

public class JsonTest{
   public static void main(String[] args){
      JSONObject obj = new JSONObject();
      obj.put("Name", "Austin");
      obj.put("Year", "Sophomore");
      obj.put("Age", 19);
      System.out.println(obj);
      System.out.print("Key 'Age' has value: " + obj.get("Age").toString());
   }
}
