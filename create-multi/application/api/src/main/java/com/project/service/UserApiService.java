package com.project.service;

import com.project.apidto.UserDto;
import com.project.apidto.UserLoginIdPwDto;
import com.project.apidto.save.UserSaveDto;
import com.project.User;
import com.project.subdomain.Address;
import com.project.subdomain.Tier;
import com.project.repository.UserApiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class UserApiService {

    private final UserApiRepository userApiRepository;

    /**
     * 유저를 저장하는 로직
     * @param userSaveDto 저장할 유저의 정보를 받는 파라미터
     * @return 저장한 유저의 정보를 반환
     */
    public UserDto saveUser(UserSaveDto userSaveDto) {
        Address address = new Address(
                userSaveDto.getZipcode(),
                userSaveDto.getCity(),
                userSaveDto.getStreet()
        );
        User user = new User(
                userSaveDto.getLoginId(),
                userSaveDto.getName(),
                userSaveDto.getAge(),
                userSaveDto.getEmail(),
                userSaveDto.getPassword(),
                address,
                Tier.NORMAL,
                0
        );
        User saveUser = userApiRepository.save(user);
        return new UserDto(
                saveUser.getId(),
                saveUser.getLoginId(),
                saveUser.getName(),
                saveUser.getAge(),
                saveUser.getEmail(),
                saveUser.getAddress(),
                saveUser.getTier(),
                saveUser.getAccumulatedAmount()
        );

    }

    /**
     * 유저의 이름과 이메일로 유저의 아이디와 패스워드를 찾기 위한 로직
     * @param name 찾기 위한 이름
     * @param email 찾기 위한 이메일
     * @return 찾은 아이디와 패스워드 반환
     */
    @Transactional(readOnly = true)
    public UserLoginIdPwDto findByNameAndEmail(String name, String email) {
        return userApiRepository.findByNameAndEmail(name,email);
    }
}
