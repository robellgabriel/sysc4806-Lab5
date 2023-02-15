var AddressInfo = {
    getAddressInfo: function() {
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "/getAddressBook"
        }).then(function(data) {
            $('.greeting-id').append(data.id);
            $('.greeting-content').append(data.content);
        });
    });
};
