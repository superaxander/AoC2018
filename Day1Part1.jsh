File file = new File("day1_input.txt");
if(!file.exists()) {
    System.err.println("Can't find day1_input.txt");
    System.exit(1);
}

BufferedReader reader = new BufferedReader(new FileReader(file));

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
    }
}
System.out.println("Result: "+result);
/exit
