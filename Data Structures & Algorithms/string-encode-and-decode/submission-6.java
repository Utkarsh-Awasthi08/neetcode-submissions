class Solution {
   

    public String encode(List<String> strs) {
         StringBuilder encoded = new StringBuilder();

        for (String s : strs) {
            encoded.append(s.length())
                   .append('#')
                   .append(s);
        }

        return encoded.toString();
    }

    public List<String> decode(String encoded) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < encoded.length()) {
            // Find the separator after the length
            int separator = encoded.indexOf('#', i);

            // Parse the string length
            int length = Integer.parseInt(
                encoded.substring(i, separator)
            );

            // Start of the actual string
            int start = separator + 1;
            int end = start + length;

            // Extract exactly "length" characters
            result.add(encoded.substring(start, end));

            // Move to the next encoded string
            i = end;
        }

        return result;
    }
}
