
function del(path, id) {
    if (confirm("Bạn chắc chắn xóa không?")) {
        fetch(path, {
            method: "delete"
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Something wrong!!!");
        });
    }
}
