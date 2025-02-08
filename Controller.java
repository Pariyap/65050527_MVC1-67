import Model.FourUdderModel;
import Model.ThreeUdderModel;
import Model.farmModel;

public class Controller {
    private farmModel farm;
    private MainView inputView;
    private CowView cowView;
    private GoatView goatView;
    private FourUdderModel fourUdderCow;
    private ThreeUdderModel threeUdderModel;

    Controller() {
        farm = new farmModel();
        inputView = new MainView();
        cowView = new CowView();
        goatView = new GoatView();
        fourUdderCow = new FourUdderModel();
        threeUdderModel = new ThreeUdderModel();

    }

    public void startTheProcesss() {
        // farm.randomAnimalsData();
        /* use for the first time only, just to crate a amount of data autoamtically */
        int cowsID = inputView.getCowsID();
        if (checkInputError(cowsID)) {
            checkifCows(cowsID);
        }
    }

    public boolean checkInputError(int id) {
        String idStr = String.valueOf(id);

        // Check if the ID is 8 digits long and doesn't start with 0
        if (idStr.length() != 8 || idStr.charAt(0) == '0') {
            inputView.displayInputError();
            return false;
        } else if (checkValidData(id)) {
            inputView.displayNotFoundData();
            return false;
        }

        return true;
    }

    public boolean checkValidData(int id) {
        farmModel tempFarm = farm.readRecords(id);
        if (id != tempFarm.getCowID()) {
            return true;
        }
        return false;
    }

    public void checkifCows(int id) {
        farmModel tempFarm = farm.readRecords(id);
        String checkIfGoat = String.valueOf(tempFarm.getUdderAmounts());
        System.err.println(checkIfGoat);
        if (checkIfGoat.equals("0")) {
            System.out.println("Hello Goat");
            goatView.IfoundtheGoat();
        }

        else {
            if (tempFarm.getUdderAmounts() == 3) {
                threeUdderModel.luckyUdder(id);
                cowView.disableCow();

            }

            else {
                int milk = fourUdderCow.calculateMiik(id);
                cowView.showsMilkamount(id, milk);
            }

        }

    }

}