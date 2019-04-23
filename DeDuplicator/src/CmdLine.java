public class CmdLine {

    public String opType;

    public String fileName;
    public String lockerPath;
    public int charset;
    public static boolean isNewPath = false;

    public boolean readIn(String[] input) {

        opType = input[0];
        fileName = input[1];
        boolean flag = false;
        if(input[2].compareTo("-locker")==0) {
            lockerPath = System.getProperty("user.dir") + "/" + input[3];
            flag = manageFunc();
        }
        else{
            System.out.println("[Error] Unsupported type in args[2]");
        }
        if(opType.compareTo("-findSubString")==0){
            try{
                charset = Integer.parseInt(input[4]);
            }catch(IndexOutOfBoundsException e){
                System.out.println("[Error] Seems something wrong with your args");
                e.printStackTrace();
            }
        }
        return flag;
    }

    private boolean manageFunc(){
        boolean flag = false;
        if (opType.compareTo("-addFile")==0) {
            if(!Tools.checkExist(lockerPath)){
                Tools.makeExist(lockerPath);
                isNewPath = true;
            }
            flag = true;
        }
        else if (opType.compareTo("-retrieveFile")==0) {
            if(!Tools.checkExist(lockerPath)){
                System.out.println("[Error] Appointed locker not found");
            }
            flag = true;
        }
        else if (opType.compareTo("-findSubString")==0){
            if(!Tools.checkExist(lockerPath)){
                System.out.println("[Error] Appointed locker not found");
            }
            flag = true;
        }

        else if (opType.compareTo("-addImage") == 0){
            if(!Tools.checkExist(lockerPath)){
                Tools.makeExist(lockerPath);
                isNewPath = true;
            }
            flag = true;
        }

        else if (opType.compareTo("-retrieveImage")==0) {
            if(!Tools.checkExist(lockerPath)){
                System.out.println("[Error] Appointed locker not found");
            }
        }

        else if (opType.compareTo("-deleteFile") == 0) {
            if(!Tools.checkExist(lockerPath)){
                System.out.println("[Error] Appointed locker not found");
            }
        }

        else {
            System.out.println("[Error] Operation not supported");
        }
        return flag;
    }
}