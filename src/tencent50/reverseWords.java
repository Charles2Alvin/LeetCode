package tencent50;

class reverseWords {
    public String reverseWords(String s) {
        // 这题的重点在于利用字符串的split方法，以及StringBuilder的reverse方法
        StringBuilder res = new StringBuilder();
        String[] words = s.split(" ");
        for (String word : words) {
            res.append(new StringBuilder(word).reverse().toString() + ' ');
        }
        // trim方法剪去头尾的空白
        return res.toString().trim();
    }
}