//Name 洪梓軒
//Student ID F74006111
//TocHw4.java
//
//將URL裡的資料讀進JSONArray裡
//用for loop 跑過每一筆資料
//用4 個if 分別判斷'路', '街', '大道', '巷'
//分類好後 再把一樣路名的資料標示出來
//順便儲存資料的 名稱 交易年月 總價元
//計算出最多筆交易年月的資料後 印出
//也印出該資料的最高成交量與最低成交量

import org.json.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Object;
import java.io.*;
import java.util.*;
import java.net.*;

public class TocHw4 {

	public static void main(String[] args) {
		String str = new String();
		String line = new String();
		int max_distinct_month = 0;
		int count = 0;
        try {  
            URL url = new URL(args[0]);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));	
            while ((line = br.readLine()) != null) {
            	str += line;              
            }
            JSONTokener jt = new JSONTokener(str);                
            JSONArray arr = new JSONArray(jt);    
            HashMap<String, Integer> dist = new HashMap<String, Integer>();
            List[] a = new List[2000];
            ArrayList dateList[] = new ArrayList[2000];
            ArrayList<String> nameList[] = new ArrayList[2000];
            ArrayList<Integer> priceList[] = new ArrayList[2000];
            int size = arr.length();
            for(int i=0; i<size; i++){
            	if(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").contains("路")){
            		if(dist.get(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("路")))==null){
            			dist.put(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("路")), count);
            			dateList[count] = new ArrayList();
            			nameList[count] = new ArrayList();
            			priceList[count] = new ArrayList();
            			nameList[count].add(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("路")+1));
            			dateList[count].add(arr.getJSONObject(i).getInt("交易年月"));
            			priceList[count].add(arr.getJSONObject(i).getInt("總價元"));
            			count++;
            		}else{
            			if(!dateList[dist.get(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("路")))].contains(arr.getJSONObject(i).getInt("交易年月"))){
            				dateList[dist.get(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("路")))].add(arr.getJSONObject(i).getInt("交易年月"));
            			}
            			if(!priceList[dist.get(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("路")))].contains(arr.getJSONObject(i).getInt("總價元"))){
            				priceList[dist.get(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("路")))].add(arr.getJSONObject(i).getInt("總價元"));
            			}
            		}
            	//	System.out.print(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("路")+1));
            	//	System.out.print("\t"+dist.get(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("路"))));
            	//	System.out.println("\t" +arr.getJSONObject(i).getInt("交易年月"));
            	} else if(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").contains("街")){
            		if(dist.get(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("街")))==null){
            			dist.put(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("街")), count);
            			dateList[count] = new ArrayList();
            			nameList[count] = new ArrayList();
            			priceList[count] = new ArrayList();
            			nameList[count].add(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("街")+1));
            			dateList[count].add(arr.getJSONObject(i).getInt("交易年月"));
            			priceList[count].add(arr.getJSONObject(i).getInt("總價元"));
            			count++;
            		}else{
            			if(!dateList[dist.get(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("街")))].contains(arr.getJSONObject(i).getInt("交易年月"))){
            				dateList[dist.get(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("街")))].add(arr.getJSONObject(i).getInt("交易年月"));
            			}
            			if(!priceList[dist.get(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("街")))].contains(arr.getJSONObject(i).getInt("總價元"))){
            				priceList[dist.get(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("街")))].add(arr.getJSONObject(i).getInt("總價元"));
            			}
            		}
            	} else if(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").contains("大道")){
            		if(dist.get(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("大道")))==null){
            			dist.put(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("大道")), count);
            			dateList[count] = new ArrayList();
            			nameList[count] = new ArrayList();
            			priceList[count] = new ArrayList();
            			nameList[count].add(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("大道")+1));
            			dateList[count].add(arr.getJSONObject(i).getInt("交易年月"));
            			priceList[count].add(arr.getJSONObject(i).getInt("總價元"));
            			count++;
            		}else{
            			if(!dateList[dist.get(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("大道")))].contains(arr.getJSONObject(i).getInt("交易年月"))){
            				dateList[dist.get(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("大道")))].add(arr.getJSONObject(i).getInt("交易年月"));
            			}
            			if(!priceList[dist.get(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("大道")))].contains(arr.getJSONObject(i).getInt("總價元"))){
            				priceList[dist.get(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("大道")))].add(arr.getJSONObject(i).getInt("總價元"));
            			}
            		}
            	} else if(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").contains("巷")){
            		if(dist.get(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("巷")))==null){
            			dist.put(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("巷")), count);
            			dateList[count] = new ArrayList();
            			nameList[count] = new ArrayList();
            			priceList[count] = new ArrayList();
            			nameList[count].add(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("巷")+1));
            			dateList[count].add(arr.getJSONObject(i).getInt("交易年月"));
            			priceList[count].add(arr.getJSONObject(i).getInt("總價元"));
            			count++;
            		}else{
            			if(!dateList[dist.get(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("巷")))].contains(arr.getJSONObject(i).getInt("交易年月"))){
            				dateList[dist.get(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("巷")))].add(arr.getJSONObject(i).getInt("交易年月"));
            			}
            			if(!priceList[dist.get(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("巷")))].contains(arr.getJSONObject(i).getInt("總價元"))){
            				priceList[dist.get(arr.getJSONObject(i).getString("土地區段位置或建物區門牌").substring(0, arr.getJSONObject(i).getString("土地區段位置或建物區門牌").lastIndexOf("巷")))].add(arr.getJSONObject(i).getInt("總價元"));
            			}
            		}
            	}
            }
            for(int i=0; i<count; i++){
            	if(dateList[i].size()>max_distinct_month)
            		max_distinct_month=dateList[i].size();
            }
            for(int i=0; i<count; i++){
            	if(dateList[i].size()==max_distinct_month){
            		System.out.print(nameList[i].get(0));
            		System.out.print(", 最高成交價: "+Collections.max(priceList[i]));
            		System.out.println(", 最低成交價: "+Collections.min(priceList[i]));
            	}
            }
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (JSONException e) {
        	e.printStackTrace();  
        }
	}
}