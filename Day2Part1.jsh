File file = new File("D:/Programming/AdventOfCode/day2_input.txt");
if (!file.exists()) {
    System.err.println("Can't find day2_input.txt");
} else {
    int countTwo = 0;
    int countThree = 0;
    BufferedReader reader = new BufferedReader(new FileReader(file));    
    String line;
    while((line = reader.readLine()) != null) {
        char[] chars = line.toCharArray();
        Map<Character, Integer> counter = new HashMap<>();
        for(char c : chars) {
            if(counter.containsKey(c)) {
                counter.put(c, counter.get(c) + 1);
            } else {
                counter.put(c, 1);
            }
        }
        boolean incrementedTwo = false;
        boolean incrementedThree = false;
        for(Integer count : counter.values()) {
            if(count == 2 && !incrementedTwo) {
                countTwo++;
                incrementedTwo = true;
            }else if(count == 3 && !incrementedThree) {
                countThree++;
                incrementedThree = true;
            }
        }
    }
    reader.close();
    System.out.println("Checksum: " + countTwo * countThree);
}
Thread.sleep(1000);
/exit
