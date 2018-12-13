File file = new File("D:/Programming/AdventOfCode/day1_input.txt");
if(!file.exists()) {
    System.err.println("Can't find day1_input.txt");
} else {
    ArrayList<Integer> list = new ArrayList<Integer>();
    int result = 0;
    list.add(0);
outer:
    while(true) {
        BufferedReader reader = new BufferedReader(new FileReader(file));    
        String line;
        while((line = reader.readLine()) != null) {
            int mod = 0;
            try{
                mod = Integer.parseInt(line);
            } catch(NumberFormatException nfe) {
                nfe.printStackTrace();
            }finally {
                result += mod;
                if(list.contains(result)) {
                    System.out.println("Result: "+result);
                    break outer;
                }else {
                    list.add(result);
                }
            }
        }
        reader.close();
    }
}
Thread.sleep(1000);
/exit
