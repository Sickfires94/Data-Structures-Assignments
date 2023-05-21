class MainModified {
    public static void main(String[] args) {
       ModifiedSearchEngine se = new ModifiedSearchEngine();

       se.insert("KaraCHI", "URL1");
       se.insert("KaraCHI", "URL2");
       se.insert("KaraCHI", "URL3");
       se.insert("KaraCHI", "URL4");

       se.insert("abc", "url1");
       se.insert("abc", "url2");
       se.insert("abc", "url3");
       se.insert("abc", "url4");
       se.insert("abc", "url5");
       se.insert("ayj", "url1");
       se.insert("ayj", "url2");
       se.insert("ayj", "url3");
       se.insert("ayj", "url4");

       System.out.println(se);
       System.out.println("*************************");
       se.Search("abc");
       se.Search("Karachi");
       se.Search("Ayj");


      se.delete("abc");
     //  se.delete("aYj");
      // se.delete("kARAchi");
       se.Search("ABc");
       se.Search("abC");
       se.Search("abC");
       System.out.println(se);

    }
}

class MainNonModified {
   public static void main(String[] args) {
      SearchEngine se = new SearchEngine();

      se.insert("Karachi", "");
      se.insert("Karachi", "url1");
      se.insert("Karachi", "ur2");

      se.insert("abc", "url1");
      se.insert("abc", "url2");
      se.insert("abc", "url3");
      se.insert("abc", "url4");
      se.insert("abc", "url5");
      se.insert("ayj", "url1");
      se.insert("ayj", "url2");
      se.insert("ayj", "url3");
      se.insert("ayj", "url4");

      System.out.println(se);
      System.out.println("*************************");
      se.Search("abc");
      se.Search("Karachi");
      se.Search("Ayj");


      se.delete("abc");
      //  se.delete("aYj");
      // se.delete("kARAchi");
      se.Search("ABc");
      se.Search("abC");
      se.Search("abC");
      System.out.println(se);

   }
}

