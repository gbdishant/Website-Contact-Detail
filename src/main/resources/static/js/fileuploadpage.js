$(function () {
    showFileName();

    $("#but_upload").click(function () {
        let fd = new FormData();
        let files = $("#chooseFile")[0].files[0];
        fd.append("file", files);

        if (files == null) {
            $("#chooseFile").tooltip('enable').tooltip('show');
            setTimeout(function () {
                $('#chooseFile').tooltip('hide').tooltip('disable');
            }, 3000);
            return;
        }
        $.ajax({
            url: "/upload", type: "post", data: fd, contentType: false, beforeSend: function () {
                $("#but_upload")
                    .fadeIn(3000)
                    .html("Please Wait...")
                    .prop("disabled", true);
            }, complete: function () {
                $("#but_upload").html("Submit").prop("disabled", false);
            }, processData: false, dataType: "json", success: function (response) {
                $("#siteListTable").removeAttr("hidden");
                $("#siteListTable").dataTable({
                    paging: false, stateSave: true, destroy: true, dom: "Bfrtip", buttons: ["copy", {
                        extend: "spacer", style: "bar",
                    }, "pdf", {
                        extend: "spacer", style: "bar",
                    }, "excel",], columns: [{
                        data: "siteName", render: function (data, type, row) {
                            return "<a href=" + data + ">" + data + "</a>";
                        },
                    }, {
                        data: "emailList", render: function (data, type, row) {
                            return data
                                .map((e) => "<a href=" + e + ">" + e + "</a>")
                                .join(", ");
                        },
                    }, {
                        data: "phoneNumberList", render: function (data, type, row) {
                            return data
                                .map((e) => "<a href=" + e + ">" + e + "</a>")
                                .join(", ");
                        },
                    },], data: response,
                });
            },
        });
    });
});

function showToolTip() {
    $('[data-toggle="tooltip"]').tooltip({
        delay: {"hide": 2000}, trigger: 'manual'
    }).on('mouseenter', function () {
        let _this = this;
        $(this).tooltip('show');
        $(".tooltip").on('mouseleave', function () {
            $(_this).tooltip('hide');
        });
    }).on('mouseleave', function () {
        var _this = this;
        setTimeout(function () {
            if (!$(".tooltip:hover").length) {
                $(_this).tooltip('hide');
            }
        }, 2000);
    });
}

function showFileName() {
    showToolTip();
    if ($("#noFile").text() === "") {
        showToolTip();
    }
    $("#chooseFile").bind("change click", function () {
        $("#chooseFile").tooltip('hide');
        let fileName = $("#chooseFile").val();
        if (/^\s*$/.test(fileName)) {
            $(".file-upload").removeClass("active");
            $("#noFile").text("No file chosen...");
        } else {
            $(".file-upload").addClass("active");
            $("#noFile").text(fileName.replace("C:\\fakepath\\", ""));
        }
    });
}

if (window.history.replaceState) {
    window.history.replaceState(null, null, window.location.href);
}
