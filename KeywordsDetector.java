public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        int i;
        String lowerString;
        String[] lowerKeys = new String[keywords.length];
        boolean containsKey=false;
        
        for(i=0; i<keywords.length; i++){
            lowerKeys[i] = keywords[i].toLowerCase();
        }

        for(i=0; i<sentences.length; i++){
           // System.out.println(sentences[i]);
            lowerString = sentences[i].toLowerCase();
           // System.out.println("i=" + i + " string= " + lowerString);
            for(int j = 0; j<lowerKeys.length; j++ ){
              //  System.out.println("check word;" + lowerKeys[j]);
                containsKey = lowerString.contains(lowerKeys[j]);
                if(containsKey){
                    System.out.println(sentences[i]);
                    break;
                }
            }
            } 
       // System.out.println(containsKey);
        }
    }

