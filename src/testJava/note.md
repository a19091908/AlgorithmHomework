## Parallel(平行運算)


   **多個執行緒同時**做不同的事。
   
   
   1.  例子：計算費波南西數、排序
   
   2.  實作：Java中可使用ForkJoin實作，[連結](https://github.com/a19091908/AlgorithmHomework/tree/master/src/testJava)
   
   3.  實作細節：
    
      (1) 繼承RecursiveAction或RecursiveTask，並實作compute方法。
   
      (2) 在某個上限以上使用平行運算；而在上限以下使用recurrent計算。
   
      (3) 在每次Divde & Conquer時，將每個recurrent使用fork方法以達到平行運算。
   
      (4) 例如：假設設定上限為10，當計算費波南西(11)時，首先會使用invoke(也就是會fork後join)
      ，接下來會進入compute方法中，因為此時11大於上限
      ，因此執行Divde & Conquer會將費波南西(10)及費波南西(9)也做invoke。
      以上敘述換句話說就是除了最一開呼叫的fork，我們又多呼叫了兩個fork來協助運算。

## Concurrent(並行運算)

   在**同一時間只能有一個執行緒**做事。
   
   
   1.  例子：寄送會員認證信、登入通知
   
   2.  實作：Java中可使用Thread或Runnable實作，[連結](https://github.com/a19091908/AlgorithmHomework/tree/master/src/testJava)


