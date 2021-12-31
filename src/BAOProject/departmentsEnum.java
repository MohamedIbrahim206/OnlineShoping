package BAOProject;

    public enum departmentsEnum {
        Meats(0) , Legumes(1) , DiartyProducts(2) , Vegetables(3);

        private int departValue;
        departmentsEnum(int i) {
            this.departValue = i;
        }

        public int getDepartValue (){
            return departValue;
        }

        public departmentsEnum getDepartment(int i){

            return switch (i) {
                case 0 -> departmentsEnum.Meats;
                case 1 -> departmentsEnum.Legumes;
                case 2 -> departmentsEnum.DiartyProducts;
                case 3 -> departmentsEnum.Vegetables;
                default -> null;
            };
        }
}
