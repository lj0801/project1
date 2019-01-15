package bwei.com.day7_rikao.Bean;

import java.io.Serializable;
import java.util.List;

public class QuanShopBean   implements Serializable {

    /**
     * result : [{"commodityId":1,"content":"哈哈哈","createTime":1547572996000,"greatNum":3,"headPic":"http://172.17.8.100/images/small/head_pic/2019-01-09/20190109114509.png","id":468,"image":"http://172.17.8.100/images/small/circle_pic/2019-01-15/2410720190115112316.jpg","nickName":"上善若水","userId":571,"whetherGreat":2},{"commodityId":1,"content":"天天开心","createTime":1547572877000,"greatNum":4,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":467,"image":"","nickName":"WJ_hw0z3","userId":980,"whetherGreat":2},{"commodityId":1,"content":"DataBean就是任性","createTime":1547572281000,"greatNum":19,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":466,"image":"http://172.17.8.100/images/small/circle_pic/2019-01-15/9082720190115111121.png","nickName":"lO_4O24o","userId":604,"whetherGreat":2},{"commodityId":1,"content":"美美哒","createTime":1547568830000,"greatNum":43,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":465,"image":"http://172.17.8.100/images/small/circle_pic/2019-01-15/0784220190115101350.jpg,http://172.17.8.100/images/small/circle_pic/2019-01-15/8973520190115101350.jpg","nickName":"DY_3994m","userId":827,"whetherGreat":2},{"commodityId":23,"content":"啊啊","createTime":1547568750000,"greatNum":5,"headPic":"http://172.17.8.100/images/small/head_pic/2019-01-14/20190114194327.jpg","id":464,"image":"","nickName":"hjkl","userId":411,"whetherGreat":2}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 1
         * content : 哈哈哈
         * createTime : 1547572996000
         * greatNum : 3
         * headPic : http://172.17.8.100/images/small/head_pic/2019-01-09/20190109114509.png
         * id : 468
         * image : http://172.17.8.100/images/small/circle_pic/2019-01-15/2410720190115112316.jpg
         * nickName : 上善若水
         * userId : 571
         * whetherGreat : 2
         */

        private String commodityId;
        private String content;
        private long createTime;
        private String greatNum;
        private String headPic;
        private String id;
        private String image;
        private String nickName;
        private String userId;
        private String whetherGreat;

        public String getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(String commodityId) {
            this.commodityId = commodityId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(String greatNum) {
            this.greatNum = greatNum;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getWhetherGreat() {
            return whetherGreat;
        }

        public void setWhetherGreat(String whetherGreat) {
            this.whetherGreat = whetherGreat;
        }
    }
}
