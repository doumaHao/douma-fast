
# 系统参数表
CREATE TABLE `sys_param` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `param_type` varchar(20) NOT NULL COMMENT '参数种类',
  `param_key` varchar(50) DEFAULT NULL COMMENT '参数键',
  `param_value` varchar(100) DEFAULT NULL COMMENT '参数值',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_id` varchar(50) DEFAULT NULL COMMENT '创建人',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_id` varchar(50) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统参数表';

