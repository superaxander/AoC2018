File file = new File("day1_input.txt");
if(!file.exists()) {
    System.err.println("Can't find day1_input.txt");
/exit
}
ArrayList<Integer> list = new ArrayList<Integer>();

while(true) {
    BufferedReader reader = new BufferedReader(new FileReader(file));    
    try{
        int result = 0;
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
/exit
                }else {
                    list.add(result);
                }
            }
        }
    } catch(EOFException e) {
    } finally{
        reader.close();
    }
}
/exit
