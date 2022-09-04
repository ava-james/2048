import java.awt.Color;

public class Tile{
  int val;
  Color color;

  public Tile(){
    val = 0;
  }

  public Tile(int num){
    val = num;
  }

  public int getValue(){
    return val;
  }

  public void setValue(int val){
    this.val = val;
  }

  public boolean isEmpty(){
    if(val == 0){
      return true;
    }
  return false;
  }

  public boolean hasValue(){
    if(val != 0){
      return true;
    }
  return false;
  }

  public String toString(){
    return "" + val;
  }

  public void setColor(){
    if(this.getValue() == 2){
      color = new Color(238, 228, 218);
    }else if(this.getValue() == 4){
      color = new Color(237,224,200);
    }else if(this.getValue() == 8){
      color = new Color(242,177,121);
    }else if(this.getValue() == 16){
      color = new Color(245,149,99);
    }else if(this.getValue() == 32){
      color = new Color(246,124,95);
    }else if(this.getValue() == 64){
      color = new Color(246,94,59);
    }else if(this.getValue() == 128){
      color = new Color(237,207,114);
    }else if(this.getValue() == 256){
      color = new Color(237,204,97);
    }else if(this.getValue() == 512){
      color = new Color(237,200,80);
    }else if(this.getValue() == 1024){
      color = new Color(237,197,63);
    }else{
      color = new Color(237,194,46);
    }
  }

  public Color getColor(){
    this.setColor();
    return color;
  }

  public void setDarkColor(){
    if(this.getValue() == 0){
      color = Color.gray;
    }else if(this.getValue() == 2){
      color = new Color(153, 159, 209);
    }else if(this.getValue() == 4){
      color = new Color(150, 159, 243);
    }else if(this.getValue() == 8){
      color = new Color(121, 130, 242);
    }else if(this.getValue() == 16){
      color = new Color(99, 103, 245);
    }else if(this.getValue() == 32){
      color = new Color(86, 77, 222);
    }else if(this.getValue() == 64){
      color = new Color(88, 61, 246);
    }else if(this.getValue() == 128){
      color = new Color(114, 158, 237);
    }else if(this.getValue() == 256){
      color = new Color(97, 99, 237);
    }else if(this.getValue() == 512){
      color = new Color(80, 98, 237);
    }else if(this.getValue() == 1024){
      color = new Color(63, 63, 237);
    }else{
      color = new Color(40, 40, 159);
    }
  }

  public Color getDarkColor(){
    this.setDarkColor();
    return color;
  }

   public void setRainbowColor(){
    if(this.getValue() == 0){
      color = Color.white;
    }else if(this.getValue() == 2){
      color = new Color(255, 69, 69);
    }else if(this.getValue() == 4){
      color = new Color(255, 93, 58);
    }else if(this.getValue() == 8){
      color = new Color(255, 124, 29);
    }else if(this.getValue() == 16){
      color = new Color(255, 165, 29);
    }else if(this.getValue() == 32){
      color = new Color(248, 235, 113);
    }else if(this.getValue() == 64){
      color = new Color(172, 246, 99);
    }else if(this.getValue() == 128){
      color = new Color(68, 171, 55);
    }else if(this.getValue() == 256){
      color = new Color(76, 207, 172);
    }else if(this.getValue() == 512){
      color = new Color(61, 127, 255);
    }else if(this.getValue() == 1024){
      color = new Color(64, 50, 178);
    }else{
      color = new Color(104, 34, 194);
    }
  }

  public Color getRainbowColor(){
    this.setRainbowColor();
    return color;
  }
}