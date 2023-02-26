package com.front;

import com.back.example.TestOutputSheet;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Result {


        public Text F14;
        public Text B11;
        public Text F13;
        public Text F12;
        public Text F11;
        public Text F10;
        public Text B14;
        public Text B13;
        public Text B12;
        public Text G14;
        public Text G9;
        public Text G12;
        public Text G11;
        public Text G10;


        public Text B10;
        public Text F9;
        public Text C14;

        public Text D11;
        public Text C11;
        public Text D10;
        public Text C10;
        public Text D9;
        public Text C9;
        public Text D13;
        public Text D14;
        public Text G13;
        public Text C23;
        public Text C22;
        public Text C21;
        public Text C20;
        public Text C19;
        public Text C18;
        public Text C17;
        public Text B27;
        public Text B26;
        public Text B25;
        public Text B24;
        public Text B23;
        public Text B22;
        public Text B21;
        public Text B20;
        public Text B19;
        public Text B18;
        public Text B17;
        public Text D22;
        public Text D21;
        public Text D20;
        public Text D19;
        public Text D18;
        public Text D17;
        public Text C27;
        public Text C26;
        public Text C25;
        public Text C24;
        public Text D27;
        public Text D26;
        public Text D25;
        public Text D24;
        public Text D23;
        public Text E17;
        public Text E18;
        public Text E19;
        public Text E20;
        public Text E21;
        public Text E26;
        public Text E25;
        public Text E24;
        public Text E23;
        public Text F26;
        public Text F22;
        public Text E22;
        public Text F23;
        public Text F24;
        public Text F25;
        public Text F27;
        public Text F17;
        public Text F18;
        public Text F19;
        public Text F20;
        public Text F21;
        public Text E27;
        public Text G17;
        public Text G18;
        public Text G19;
        public Text G20;
        public Text G21;
        public Text G22;
        public Text G23;
        public Text G24;
        public Text G25;
        public Text G26;
        public Text G27;
        public Text D35;
        public Text D34;
        public Text D33;
        public Text D32;
        public Text D31;
        public Text D30;
        public Text D29;
        public Text D39;
        public Text D38;
        public Text D37;
        public Text D36;
        public Text G33;
        public Text G39;
        public Text Story_id;
        public Text CompanyName_id;

    public Text B9;
/*所有的参数按照initialize来填*/
    @FXML
    public void initialize() {
        double outputB9 = TestOutputSheet.outputB9();
        B9.setText(String.valueOf(outputB9));
    }
}
