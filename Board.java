public class Board{
  public Tile[][] board;
  int size = 4;
  int score =0;

  public Board(){
    board = new Tile[4][4];
    for(int r=0; r<board.length; r++){
      for(int c=0; c<board[r].length; c++){
        board[r][c] = new Tile();
      }
    }
  }

  public Board(int size){
    this.size = size;
    board = new Tile[size][size];
    for(int r=0; r<board.length; r++){
      for(int c=0; c<board[r].length; c++){
        board[r][c] = new Tile();
      }
    }
  }

  public Tile[][] getBoard(){
    return board;
  }

  public void start(){
    int r1 = (int)(Math.floor(Math.random()*4));
    int c1 = (int)(Math.floor(Math.random()*4));
    int r2 = (int)(Math.floor(Math.random()*4));
    int c2 = (int)(Math.floor(Math.random()*4));

    double rand = Math.random();

    int  count = 0;
    String s1 = r1+""+c1;
    String s2 = r2+""+c2;
    while(count == 0){
      if(s1.equals(s2)){
        r2 = (int)(Math.floor(Math.random()*4));
        c2 = (int)(Math.floor(Math.random()*4));
        s2  = r2+""+c2;
      }else{
        if(rand >= 0.8){
          board[r1][c1].setValue(4);
          board[r2][c2].setValue(2);
          count++;
        }else{
          board[r1][c1].setValue(2);
          board[r2][c2].setValue(2);
          count++;
        }
      }
    }
  }

  public boolean isUpPossible(){
    for(int r=1; r<board.length; r++){
      for(int c=0; c<board[r].length; c++){
        Tile tile = board[r][c];
        Tile upTile = board[r-1][c];
        if((tile.hasValue() && upTile.isEmpty()) || (tile.getValue()>0 && tile.getValue()==upTile.getValue())){
          return true;
        }
      }
    }
    return false;
  }

  public void up(){
    for(int r=1; r<board.length; r++){
      for(int c=0; c<board[r].length; c++){
        if(board[r][c].hasValue()){
          while(r > 0 && board[r-1][c].isEmpty()){
            board[r-1][c].setValue(board[r][c].getValue());
            board[r][c].setValue(0);
            r--;
          }
          if(r > 0 && board[r][c].getValue() == board[r-1][c].getValue()){
            score+=(board[r][c].getValue()+board[r-1][c].getValue());
            board[r-1][c].setValue(board[r][c].getValue() +  board[r-1][c].getValue());
            board[r][c].setValue(0);  
            r--;
          }
        }
      }
    }
  }

  public boolean isDownPossible(){
    for(int r=0; r<board.length-1; r++){
      for(int c=0; c<board[r].length; c++){
        Tile tile = board[r][c];
        Tile downTile = board[r+1][c];
        if((tile.hasValue() && downTile.isEmpty()) || (tile.getValue()>0 && tile.getValue()==downTile.getValue())){
          return true;
        }
      }
    }
    return false;
  }


  public void down(){
    for(int r=board.length-1; r>=0; r--){
      for(int c=board[r].length-1; c>=0; c--){
        if(board[r][c].hasValue()){
          while(r < 3 && board[r+1][c].isEmpty()){
            board[r+1][c].setValue(board[r][c].getValue());
            board[r][c].setValue(0);
            r++;
          }
          if(r < 3 && board[r][c].getValue() == board[r+1][c].getValue()){
            score+=(board[r][c].getValue()+board[r+1][c].getValue());
            board[r+1][c].setValue(board[r][c].getValue() + board[r+1][c].getValue());
            board[r][c].setValue(0);  
            r++;
          }
        }
      }
    }
  }

  public boolean isRightPossible(){
    for(int r=0; r<board.length; r++){
      for(int c=0; c<board[r].length-1; c++){
        Tile tile = board[r][c];
        Tile rightTile = board[r][c+1];
        if((tile.hasValue() && rightTile.isEmpty()) || (tile.getValue()>0 && tile.getValue()==rightTile.getValue())){
          return true;
        }
      }
    }
    return false;
  }


  public void right(){
    for(int r=board.length-1; r>=0; r--){
      for(int c=board[r].length-1; c>=0; c--){
        if(board[r][c].hasValue()){
          while(c < 3 && board[r][c+1].isEmpty()){
            board[r][c+1].setValue(board[r][c].getValue());
            board[r][c].setValue(0);
            c++;
          }
          if(c < 3 && board[r][c].getValue() == board[r][c+1].getValue()){
            score+=(board[r][c].getValue()+board[r][c+1].getValue());
            board[r][c+1].setValue(board[r][c].getValue() +  board[r][c+1].getValue());
            board[r][c].setValue(0); 
            c++;
          }
        }
      }
    }
  }

  public boolean isLeftPossible(){
    for(int r=0; r<board.length; r++){
      for(int c=1; c<board[r].length; c++){
        Tile tile = board[r][c];
        Tile leftTile = board[r][c-1];
        if((tile.hasValue() && leftTile.isEmpty()) || (tile.getValue()>0 && tile.getValue()==leftTile.getValue())){
          return true;
        }
      }
    }
    return false;
  }

  public void left(){
    for(int r=0; r<board.length; r++){
      for(int c=0; c<board[r].length; c++){
        if(board[r][c].hasValue()){
          while(c > 0 && board[r][c-1].isEmpty()){
            board[r][c-1].setValue(board[r][c].getValue());
            board[r][c].setValue(0);
            c--;
          }
          if(c > 0 && board[r][c].getValue() == board[r][c-1].getValue()){
            score+=(board[r][c].getValue()+board[r][c-1].getValue());
            board[r][c-1].setValue(board[r][c].getValue() +  board[r][c-1].getValue());
            board[r][c].setValue(0);     
            c--;
          }
        }
      }
    }
  }

  public void addNewValue(){
    int r = (int)(Math.floor(Math.random()*4));
    int c = (int)(Math.floor(Math.random()*4));
    double rand = Math.random();
    int  count = 0;
    while(count == 0){
      if(board[r][c].isEmpty()){
        if(rand <= 0.8){
          board[r][c].setValue(2);
        }else{
          board[r][c].setValue(4);
        }
        count++;
      }else{
        r = (int)(Math.floor(Math.random()*4));
        c = (int)(Math.floor(Math.random()*4));
      }
    }
  }

  public void add8(){
    int r = (int)(Math.floor(Math.random()*4));
    int c = (int)(Math.floor(Math.random()*4));
    int count = 0;
    while(count == 0){
      if(board[r][c].isEmpty()){
        board[r][c].setValue(8);
        count++;
      }else{
        r = (int)(Math.floor(Math.random()*4));
        c = (int)(Math.floor(Math.random()*4));
      }
    }
  }

   public void add16(){
    int r = (int)(Math.floor(Math.random()*4));
    int c = (int)(Math.floor(Math.random()*4));
    int count = 0;
    while(count == 0){
      if(board[r][c].isEmpty()){
        board[r][c].setValue(16);
        count++;
      }else{
        r = (int)(Math.floor(Math.random()*4));
        c = (int)(Math.floor(Math.random()*4));
      }
    }
  }

  public void add32(){
    int r = (int)(Math.floor(Math.random()*4));
    int c = (int)(Math.floor(Math.random()*4));
    int count = 0;
    while(count == 0){
      if(board[r][c].isEmpty()){
        board[r][c].setValue(32);
        count++;
      }else{
        r = (int)(Math.floor(Math.random()*4));
        c = (int)(Math.floor(Math.random()*4));
      }
    }
  }

  public void add64(){
    int r = (int)(Math.floor(Math.random()*4));
    int c = (int)(Math.floor(Math.random()*4));
    int count = 0;
    while(count == 0){
      if(board[r][c].isEmpty()){
        board[r][c].setValue(64);
        count++;
      }else{
        r = (int)(Math.floor(Math.random()*4));
        c = (int)(Math.floor(Math.random()*4));
      }
    }
  }

  public void add128(){
    int r = (int)(Math.floor(Math.random()*4));
    int c = (int)(Math.floor(Math.random()*4));
    int count = 0;
    while(count == 0){
      if(board[r][c].isEmpty()){
        board[r][c].setValue(128);
        count++;
      }else{
        r = (int)(Math.floor(Math.random()*4));
        c = (int)(Math.floor(Math.random()*4));
      }
    }
  }

  public void add256(){
    int r = (int)(Math.floor(Math.random()*4));
    int c = (int)(Math.floor(Math.random()*4));
    int count = 0;
    while(count == 0){
      if(board[r][c].isEmpty()){
        board[r][c].setValue(256);
        count++;
      }else{
        r = (int)(Math.floor(Math.random()*4));
        c = (int)(Math.floor(Math.random()*4));
      }
    }
  }

  public void add512(){
    int r = (int)(Math.floor(Math.random()*4));
    int c = (int)(Math.floor(Math.random()*4));
    int count = 0;
    while(count == 0){
      if(board[r][c].isEmpty()){
        board[r][c].setValue(512);
        count++;
      }else{
        r = (int)(Math.floor(Math.random()*4));
        c = (int)(Math.floor(Math.random()*4));
      }
    }
  }

  public void add1024(){
    int r = (int)(Math.floor(Math.random()*4));
    int c = (int)(Math.floor(Math.random()*4));
    int count = 0;
    while(count == 0){
      if(board[r][c].isEmpty()){
        board[r][c].setValue(1024);
        count++;
      }else{
        r = (int)(Math.floor(Math.random()*4));
        c = (int)(Math.floor(Math.random()*4));
      }
    }
  }

  public void add2048(){
    int r = (int)(Math.floor(Math.random()*4));
    int c = (int)(Math.floor(Math.random()*4));
    int count = 0;
    while(count == 0){
      if(board[r][c].isEmpty()){
        board[r][c].setValue(2048);
        count++;
      }else{
        r = (int)(Math.floor(Math.random()*4));
        c = (int)(Math.floor(Math.random()*4));
      }
    }
  }

  public int getScore(){
    return score;
  }

  public boolean isBoardFull(){
    for(int r=0; r<board.length; r++){
      for(int c=0; c<board[r].length; c++){
        if(board[r][c].hasValue()){
          return false;
        }
      }
    }
    return true;
  }

  public boolean isWin(){
    for(int r=0; r<board.length; r++){
      for(int c=0; c<board[r].length; c++){
        if(board[r][c].getValue() == 2048 && gameOver()==false){
          return true;
        }
      }
    }
    return false;
  }

  public int getHighTile(){
    int high=0;
    for(int r=0; r<board.length; r++){
      for(int c=0; c<board[r].length; c++){
        if(board[r][c].getValue()>high){
          high = board[r][c].getValue();
        }
      }
    }
    return high;
  }

  public boolean gameOver(){
    for(int r=0; r<board.length; r++){
      for(int c=0; c<board[r].length; c++){ 
        if(board[r][c].hasValue() && isUpPossible()==false && isDownPossible()==false && isRightPossible()==false && isLeftPossible()==false){
          return true;
        }
      }
    }
    return false;
  }

  public void clearBoard(){
    for(int r=0; r<board.length; r++){
      for(int c=0; c<board[r].length; c++){
        board[r][c].setValue(0);
      }
    }
  }

  public void printBoard(){
    for(int r=0; r<board.length; r++){
      for(int c=0; c<board[r].length; c++){
        String s = board[r][c].toString() + " ";
        System.out.print(s);
      }
      System.out.println("");
    }
  }

  public String toString(){
    String s = "";
    for(int r=0; r<board.length; r++){
      for(int c=0; c<board[r].length; c++){
        s += board[r][c].toString() + " ";
      }
      s += "\n";
    }
    return s;
  }

}