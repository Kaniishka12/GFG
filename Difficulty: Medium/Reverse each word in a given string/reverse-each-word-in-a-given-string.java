class Solution {
    public String reverseWords(String s) {
        // Code here
        s=s.trim();
        String[] words=s.split("\\s+");
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<=words.length-1;i++){
                StringBuffer k=new StringBuffer(words[i]);
                sb.append(k.reverse());
                if(i!=words.length-1){
                    sb.append(" ");
                }
        }
        return sb.toString();
    }
}
