package apitest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kosta.model.EmployeeVO;

public class JsonParseTest {

	public static void main(String[] args) throws FileNotFoundException {
		f1();
		f2();
		f3();
		f4_parsing();
		f4_jsonFileRead();
	}

	private static void f4_jsonFileRead() throws FileNotFoundException {
		Reader reader = new FileReader("src/apitest/test.json");
		Gson gson = new Gson();
		Lecture lecture = gson.fromJson(reader, Lecture.class);
		System.out.println(lecture);
 
		
	}

	private static void f4_parsing() {
		String jsonStr = "{'employee_id':100,"+
	         "'phone':[10,106,3,4]," +
	         "'first_name':'��Ƽ��','salary':0,'commission_pct':0.0,'manager_id':0,'department_id':0,'next_salary':0.0}";
		JsonElement element = JsonParser.parseString(jsonStr);
		JsonObject object = element.getAsJsonObject();
		long id = object.get("employee_id").getAsLong();
		System.out.println("id : " + id); // 
		//�迭 
		JsonArray arr = object.get("phone").getAsJsonArray();
		for (int i = 0; i < arr.size(); i++) {
			String item = arr.get(i).getAsString();
			System.out.println("item[" + i + "] : " + item);  
		}
 		//JsonObject obj = object.get("first_name").getAsJsonObject();
		JsonObject obj = object.getAsJsonObject();
		String first_name = obj.get("first_name").getAsString();
		System.out.println("first_name : " + first_name);  
 	
	}

	private static void f3() {
		Gson gson = new Gson();
		String jsonStr = "{'employee_id':100,'first_name':'��Ƽ��','salary':0,'commission_pct':0.0,'manager_id':0,'department_id':0,'next_salary':0.0}";
		EmployeeVO emp = gson.fromJson(jsonStr, EmployeeVO.class);

		System.out.println(emp);

	}

	private static void f2() {
		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("name", "����");
		jsonObject.addProperty("id", 100);
		String jsonStr = gson.toJson(jsonObject);
		System.out.println(jsonStr);

	}

	private static void f1() {
		EmployeeVO emp = new EmployeeVO();
		emp.setEmployee_id(100);
		emp.setFirst_name("��Ƽ��");
		//Gson gson = new Gson();
		// PrettyPrinting �ɼ��� �߰��Ͽ� Gson ��ü ����
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String studentJson = gson.toJson(emp);
		System.out.println(studentJson);
	}

}
