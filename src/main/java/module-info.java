module sio.leo.javafx_directionsport {
    requires javafx.controls;
    requires javafx.fxml;

    opens sio.leo.javafx_directionsport to javafx.fxml;
    exports sio.leo.javafx_directionsport;
}
