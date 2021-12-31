package BAOProject;

    public enum departmentsEnum {
        Meats(1) , Legumes(2) , DiartyProducts(3) , Vegetables(4);

        private int departValue;
        departmentsEnum(int i) {
            this.departValue = i;
        }

        public int getDepartValue (){
            return departValue;
        }


}
