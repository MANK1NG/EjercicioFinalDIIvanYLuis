module es.uem.desarrollofinal.proyectofinalivanyluis {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.sql.rowset;





    opens es.uem.desarrollofinal.proyectofinalivanyluis to javafx.fxml;
    exports es.uem.desarrollofinal.proyectofinalivanyluis;
    exports es.uem.desarrollofinal.proyectofinalivanyluis.controller to javafx.fxml;
    exports es.uem.desarrollofinal.proyectofinalivanyluis.util;
    exports es.uem.desarrollofinal.proyectofinalivanyluis.model;
    opens es.uem.desarrollofinal.proyectofinalivanyluis.util to javafx.fxml;
    opens es.uem.desarrollofinal.proyectofinalivanyluis.model to javafx.fxml;
    opens es.uem.desarrollofinal.proyectofinalivanyluis.controller to javafx.fxml;
}
