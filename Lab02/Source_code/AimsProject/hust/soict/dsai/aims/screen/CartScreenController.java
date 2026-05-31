package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private Label lblTotalCost;

    // Filter components
    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;

    private FilteredList<Media> filteredList;

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        // Setup columns
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        // Wrap ObservableList with FilteredList
        filteredList = new FilteredList<>(cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredList);

        // Initially hide buttons
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Selection listener
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });

        // Filter listener
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

        // Update total cost whenever the original list changes
        cart.getItemsOrdered().addListener((ChangeListener<ObservableList<Media>>) (observable, oldValue, newValue) -> updateTotal());
        updateTotal(); // initial update
    }

    private void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            btnPlay.setVisible(media instanceof Playable);
        }
    }

    private void updateTotal() {
        float total = cart.totalCost();
        lblTotalCost.setText(String.format("%.2f $", total));
    }

    private void showFilteredMedia(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            filteredList.setPredicate(media -> true);
        } else {
            filteredList.setPredicate(media -> {
                if (radioBtnFilterId.isSelected()) {
                    return String.valueOf(media.getId()).contains(filterText);
                } else { // By Title
                    return media.getTitle().toLowerCase().contains(filterText.toLowerCase());
                }
            });
        }
        // Reset selection after filtering
        tblMedia.getSelectionModel().clearSelection();
        updateTotal(); // total not affected by filter, but keep for consistency
    }

    @FXML
    void btnRemovePressed() {
        Media selected = tblMedia.getSelectionModel().getSelectedItem();
        if (selected != null) {
            cart.removeMedia(selected);
            updateTotal();
            // TableView updates automatically because FilteredList is backed by ObservableList
        }
    }

    @FXML
    void btnPlayPressed() {
        Media selected = tblMedia.getSelectionModel().getSelectedItem();
        if (selected instanceof Playable) {
            // Hiển thị dialog play (tương tự như trong MediaStore)
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Play Media");
            alert.setHeaderText("Playing " + selected.getTitle());
            alert.setContentText("Playback simulation.\n(Implement actual play logic)");
            alert.showAndWait();
        }
    }

    @FXML
    void btnPlaceOrderPressed() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Placed");
        alert.setHeaderText(null);
        alert.setContentText("Your order has been placed successfully!");
        alert.showAndWait();
        cart.getItemsOrdered().clear(); // clear cart after order
    }

    @FXML
    void viewStoreMenuPressed() {
        // Chuyển về StoreScreen (có thể mở cửa sổ mới)
        // Tạm thời in ra console
        System.out.println("Open Store Screen");
    }

    @FXML
    void updateStoreMenuPressed() {
        System.out.println("Open Update Store Screen");
    }
}