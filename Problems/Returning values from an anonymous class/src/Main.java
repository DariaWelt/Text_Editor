/* create an instance of an anonymous class here,
                       do not forget ; on the end;
                       variables str and number will be accessible during testing */
Returner returner = new Returner() {

    @Override
    public String returnString() {
        return str;
    }

    @Override
    public  int returnInt() {
        return number;
    }
};