public class AplikasiToDoList {

    public static String [] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);


    public static void main(String[] args) {

        viewShowTodoList();

    }

    //business logic menampilkan to do list
    public static void showTodoList(){
        System.out.println("ToDo List");
        for (var i = 0; i < model.length; i++ ){
            String todo = model[i];
            var no = i + 1;

            if (todo != null){
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList(){
        model [0] = "Belajar java dasar";
        model [1] = "Studi kasus java dasar : Aplikasi TodoList";
        showTodoList();
    }

    //business logic menambah to do list
    public static void inputTodoList(String todo){
        // cek apakah model penuh?
        var isFull = true;
        for(int i = 0; i < model.length; i++){
            if (model [i] == null){
                //model masih ada yang kosong
                isFull = false;
                break;
            }
        }
        //jika penuh maka kapasitas array di kali dua
        if (isFull){
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp [i];
            }
        }


        // menambahkantodo ke dalam data array yang masih null

        for(var i = 0; i < model.length; i++){
            if (model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    public static void testInputTodoList(){
       for (int i = 0; i < 25; i++) {
            inputTodoList("todo list ke - " + i);
        }
        showTodoList();
    }

    //business logic menghapus to do list
    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {

            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }

            }
            return true;
        }
    }

    public static void testRemoveTodoList (){
        inputTodoList("Satu");
        inputTodoList("Dua");
        inputTodoList("Tiga");

      var result = removeTodoList(1);
        System.out.println(result);

        showTodoList();
    }

    public static String input (String info){
        System.out.print(info + ":");
        String data = scanner.nextLine();
        return data;

    }

    public static void testInput(){
        var nama = input("Nama");
        System.out.println("Hi"+ nama);

        var usia = input("Usia");
        System.out.println("Usia:" + usia);
    }

    // view untuk menampilkan to do list
    public static void viewShowTodoList() {
        while (true){

            showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. TAMBAH");
            System.out.println("2. HAPUS");
            System.out.println("X. Berhenti");

            var input = input("pilih");

            if (input.equals("1")) {
                viewInputTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("X")) {
                break;
            } else {
                System.out.println("inputan Anda salah");
            }
        }
    }

    public static void testViewShowTodoList(){
        inputTodoList("satu");
        inputTodoList("dua");
        inputTodoList("tiga");
        inputTodoList("empat");
        inputTodoList("lima");

        viewShowTodoList();
    }

    //view untuk menambah to do list
    public static void viewInputTodoList(){
        System.out.println("MENAMBAH TODO LIST");

        var todo = input("Todo (X Jika Batal)");

        if(todo.equals("X")){
            // Batal
        } else {
            inputTodoList(todo);
        }
    }

    public static void testViewInputTodolist(){
        inputTodoList("Satu");
        inputTodoList("dua");

        viewInputTodoList();

        showTodoList();
    }

    //view untuk menghapus to do list
    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Nomor yang dihapus (X Jika Batal)");

        if(number.equals("X")){
            // batal
        } else {
           boolean success = removeTodoList(Integer.valueOf(number));
           if(!success){
               System.out.println("Gagal menghapus todo : "+ number);
           }
        }
    }

    public static void testViewRemoveTodoList(){
        inputTodoList("Satu");
        inputTodoList("Dua");
        inputTodoList("Tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }

}
