package character_status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CharacterStatusJsoup {
	
	static List<String> characterUrls = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
	    String AllCharacterUrl = "https://arknights.wikiru.jp/?%E3%82%AD%E3%83%A3%E3%83%A9%E3%82%AF%E3%82%BF%E3%83%BC%E4%B8%80%E8%A6%A7";
	    
	    

	    
	    try {
	    	
	        Document AllCharacterdoc = Jsoup.connect(AllCharacterUrl).get();
	        getUrls(AllCharacterdoc);
	        
	        for (String url : characterUrls) {
	        	Document doc = Jsoup.connect(url).get();
	        	
	        	String characterName = getStatusByName(doc, "コードネーム");
		        System.out.println("コードネーム: " + characterName);

		        String hp = getStatusPromotion0(doc, "HP");
		        System.out.println("HP(未昇進 Lv max): " + hp);

		        String ad = getStatusPromotion0(doc, "攻撃");
		        System.out.println("攻撃力(未昇進 Lv max): " + ad);
		        
		        String ar = getStatusPromotion0(doc, "防御");
		        System.out.println("防御(未昇進 Lv max): " + ar);
		        
		        String mr = getStatusPromotion0(doc, "術耐性");
		        System.out.println("術耐性(未昇進 Lv max): " + mr);
		        
		        String tier = getStatusTier(doc, "レアリティ").substring(1);
		        System.out.println("Tier: " + tier);
	        }
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private static String getStatusByName(Document doc, String name) {
	    Elements thElements = doc.select(".style_th");

	    for (Element thElement : thElements) {
	        if (name.equals(thElement.text())) {
	            Element nextTdElement = thElement.nextElementSibling();
	            return nextTdElement.text();
	        }
	    }
	    
	    return "Not found";
	}
	
	private static String getStatusPromotion0(Document doc, String name) {
	    Elements thElements = doc.select(".style_th");

	    for (Element thElement : thElements) {
	        if (name.equals(thElement.text())) {
	            Element nextTdElement = thElement.nextElementSibling().nextElementSibling();
	            return nextTdElement.text();
	        }
	    }
	    
	    return "Not found";
	}
	
	private static String getStatusPromotion1(Document doc, String name) {
	    Elements thElements = doc.select(".style_th");

	    for (Element thElement : thElements) {
	        if (name.equals(thElement.text())) {
	            Element nextTdElement = thElement.nextElementSibling().nextElementSibling().nextElementSibling();
	            return nextTdElement.text();
	        }
	    }
	    
	    return "Not found";
	}
	
	private static String getStatusPromotion2(Document doc, String name) {
	    Elements thElements = doc.select(".style_th");

	    for (Element thElement : thElements) {
	        if (name.equals(thElement.text())) {
	            Element nextTdElement = thElement.nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling();
	            return nextTdElement.text();
	        }
	    }
	    
	    return "Not found";
	}
	
	private static String getStatusTier(Document doc, String name) {
	    Elements thElements = doc.select(".style_th");

	    for (Element thElement : thElements) {
	        if (name.equals(thElement.text())) {
	            Element nextTdElement = thElement.nextElementSibling();
	            return nextTdElement.text();
	        }
	    }
	    
	    return "Not found";
	}
	
	private static String getUrls(Document doc) {
		
		for (int i = 1; i <= 11; i++) {
			Elements aTags = doc.select("#sortabletable" + i + " a"); // classがstyle_tableの中のaタグを選択

			for (Element aTag : aTags) {
	            String url = aTag.attr("href");
	            if (url.substring(0,1).equals(".")) {
	            	url = url.replace(".", "");
	            	url = "https://arknights.wikiru.jp" + url;
	            	characterUrls.add(url);
	            }
	        }
		}
		return "Not found";
	    
	    
	}
	
}


