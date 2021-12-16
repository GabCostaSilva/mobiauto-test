SELECT CO.orderid, SUM(C.cost) AS TotalPrice
FROM componentorder CO
         JOIN component_order_ids COI ON CO.orderid = COI.orderid
         JOIN component C ON COI.componentid = C.id
WHERE CO.customername = ''DeathStar''
GROUP BY CO.orderid
