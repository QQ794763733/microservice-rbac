package cn.microservice.www.service.impl;

import cn.microservice.www.mapper.AccountMapper;
import cn.microservice.www.model.Account;
import cn.microservice.www.service.AccountService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * 账户服务实现类
 * @author MachineGeek
 */
@DubboService(version = "1.0.0")
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
    @Override
    public Account getByName(String accountName) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Account::getAccountName,accountName);
        return baseMapper.selectOne(queryWrapper);
    }
}
