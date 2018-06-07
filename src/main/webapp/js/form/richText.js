$('#summernote-write').summernote({
    lang: 'zh-CN',
    minHeight: 260,
    dialogsFade: true,
    dialogsInBody: true,
    disableDragAndDrop: false,//不可拖动，避免因拖动引起二次上传
    focus: true,
    callbacks: {
        onImageUpload: function (files) {

            data = new FormData();
            data.append("file", files[0]);

            alert(JSON.stringify(files));
            alert(JSON.stringify(files[0]));
            alert(JSON.stringify(data));

            $.ajax({
                data: data,
                type: "POST",
                url: 'summernoteWrite.ajax',
                cache: false,
                contentType: false,
                processData: false,
                success: function (url) {
                    if (url == '200') {
                        alert("上传失败！");
                        return;
                    } else {
                        alert("上传成功！");
                    }
                },
                error: function () {
                    alert("上传失败！");
                    return;
                }
            });
        }
    }
});

$('#summernote-read').summernote({
    lang: 'zh-CN',
    minHeight: 260,
});


function summernoteWrite() {

    alert($('#summernote-write').summernote('code'));

    $.ajax({
        data: {
            writeMessage: $('#summernote-write').summernote('code'),
        },
        type: "POST",
        url: 'summernoteWrite.ajax',
    });
}

function summernoteRead() {
    $.ajax({
        type: "POST",
        url: 'summernoteRead.ajax',
        success: function (data) {
            $('#summernote-read').summernote('code', data);
        }
    });
}

