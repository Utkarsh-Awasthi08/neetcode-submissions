class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> list = new ArrayList<>();
        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            list.add(new String(ch));
        }
        List<List<String>> l = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            if(!map.containsKey(list.get(i)))
            {
                l.add(new ArrayList<>(List.of(strs[i])));
                map.put(list.get(i), l.size() - 1);
            }
            else
            {
                l.get(map.get(list.get(i))).add(strs[i]);
            }
        }
        return l;
    }
}
