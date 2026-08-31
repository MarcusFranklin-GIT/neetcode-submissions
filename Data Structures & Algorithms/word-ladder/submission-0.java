class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordset = new HashSet<>();
        for(String str : wordList)wordset.add(str);

        if(!wordset.contains(endWord))return 0;
        if(wordset.contains(beginWord))wordset.remove(beginWord);

        Queue<Pair> Q = new LinkedList<>();
        Q.add(new Pair(beginWord,1));

        while(!Q.isEmpty()){
            Pair curr = Q.poll();
            String currword = curr.word;
            int level = curr.level;

            if(currword.equals(endWord))return level;

            for(int i =0 ; i < currword.length() ; i++){
                StringBuilder str = new StringBuilder(currword);

                for(char ch = 'a' ; ch<='z' ; ch++){

                    str.setCharAt(i,ch);
                    String modified = new String(str);

                    if(wordset.contains(modified)){
                        wordset.remove(modified);
                        Q.add(new Pair(modified,level+1));
                    }
                }
            }
        }
        return 0;
    }
}
class Pair{
    String word;
    int level;
    Pair(String word,int level){
        this.word = word;
        this.level = level;
    }
}
