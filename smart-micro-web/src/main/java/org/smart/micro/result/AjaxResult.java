package org.smart.micro.result;


import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

/**
 * @ClassName AjaxResult
 * @Description AJAXResult ajax返回时候结果
 * @Author jiangsida
 * @VERSION 1.0
 */

public class AjaxResult extends  AbstractResult {

    /**
     * ajax返回的值为了方便返回值这个用object返回
     */
    private  Object result;

    public AjaxResult(String status, String msg , Object result) {
        this.result = result;
        this.msg=msg;
        this.status=status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "AjaxRsult{result:"+this.result+"msg:+"+this.msg+"status:"+this.status+"}";
    }

    /**
     * 静态类该类的所有实例共享，静态类只有一种情况，就是静态内部类
     */

    public static class AjaxResultBuild{

        public  String msg;
        public  String  status;
        public  Object result;

        public  AjaxResultBuild(){}
        public  AjaxResultBuild msg( String msg){
            this.msg=msg;
            return  this;
        }

        public AjaxResultBuild result(Object result){
            this.result=result;
            return  this;
        }

         public  AjaxResultBuild status(String status){
            this.status=status;
            return  this;
         }
         public  AjaxResult build(){

            if (StringUtils.isEmpty(status)){
                status=Integer.toString(HttpStatus.OK.value());
            }
            else if(StringUtils.isEmpty(msg)){
              msg=HttpStatus.OK.getReasonPhrase();
            }
            return  new AjaxResult(this.status,this.msg,this.result);
         }
      }
}
