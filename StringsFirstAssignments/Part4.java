import edu.duke.*;

public class Part4 {
    public void findURLs(){
        String url="http://www.dukelearntoprogram.com/course2/data/manylinks.html";
        URLResource page = new URLResource(url);
        System.out.println(page);
        //StorageResource store= new StorageResource();
                for(String line: page.lines()){
            int index=line.indexOf("youtube.com");
            if(index == -1){
                break;
            }
            System.out.println(line);
        }
    }
    /*public void findURLs() {
		URLResource page = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
		String source = page.asString();
		StorageResource store = new StorageResource();
		int start = 0;
		while (true) {
			int index = source.indexOf("href=", start);
			if (index == -1) {
				break;
			}
			int firstQuote = index+6; // after href="
			int endQuote = source.indexOf("\"", firstQuote);
			String sub = source.substring(firstQuote, endQuote);
			if (sub.startsWith("http")) {
				store.add(sub);
			}
			start = endQuote + 1;
		}
		for(String link: store.data()){
		    System.out.println(link);
		}
    }*/
}
