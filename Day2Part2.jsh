File file = new File("D:/Programming/AdventOfCode/day2_input.txt");
if (!file.exists()) {
    System.err.println("Can't find day2_input.txt");
} else {    
    BufferedReader reader = new BufferedReader(new FileReader(file));
    ArrayList<String> lines = new ArrayList<>();  
    String line;
    while((line = reader.readLine()) != null) {
        for(String l : lines) {
            char[] c1 = l.toCharArray();
            char[] c2 = line.toCharArray();
            int differingIndex = -1;
            for(int i = 0; i < c1.length; i++) {
                if(c1[i] != c2[i]) {
                    if(differingIndex != -1){
                        differingIndex = -1;
                        break;
                    } else {
                        differingIndex = i;
                    }
                }
            }
            if(differingIndex != -1) {
                System.out.println("Result: "+l.substring(0,differingIndex)+l.substring(differingIndex + 1, l.length()));
            }
        }
        lines.add(line);
    }
    reader.close();
}
Thread.sleep(1000);
///exit
