$(function () {
  showFileName();
  $("#but_upload").click(function () {
    let fd = new FormData();
    let files = $("#chooseFile")[0].files[0];
    fd.append("file", files);

    $.ajax({
      url: "/upload",
      type: "post",
      data: fd,
      contentType: false,
      processData: false,
      dataType: "json",
      success: function (response) {
        $("#siteListTable").removeAttr("hidden");
        console.log("Inside",response);

        if ($.fn.DataTable.isDataTable("#siteListTable")) {
          $("#siteListTable").DataTable().destroy();
        }

        $("#siteListTable tbody").empty();
        $("#siteListTable").dataTable({
          paging: false,
          columns: [
            {
              data: "siteName",
              render: function (data, type, row) {
                return "<a href=" + data + ">" + data + "</a>";
              },
            },
            {
              data: "emailList",
              render: function (data, type, row) {
                return data
                  .map((e) => "<a href=" + e + ">" + e + "</a>")
                  .join(", ");
              },
            },
            {
              data: "phoneNumberList",
              render: function (data, type, row) {
                return data
                  .map((e) => "<a href=" + e + ">" + e + "</a>")
                  .join(", ");
              },
            },
          ],
          data: response,
        });
      },
    });
  });
});

function showFileName() {
  $("#chooseFile").bind("change", function () {
    var filename = $("#chooseFile").val();
    if (/^\s*$/.test(filename)) {
      $(".file-upload").removeClass("active");
      $("#noFile").text("No file chosen...");
    } else {
      $(".file-upload").addClass("active");
      $("#noFile").text(filename.replace("C:\\fakepath\\", ""));
    }
  });
}

if (window.history.replaceState) {
  window.history.replaceState(null, null, window.location.href);
}
