import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.google.gson.Gson;
import com.netease.cloud.nce.dto.DescDTO;
import com.netease.cloud.nce.service.DescService;
import com.netease.cloud.nce.utils.CommonData;
import com.netease.libs.holder.WebContextHolder;

/**
 * Created by hzzhouxiang on 2018/1/24.
 */
public class PoolTest {

    public static void main(String [] args){

        try {
            CommonData.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        DescDTO descDTO = new DescDTO();
//        descDTO.setBeginTest("begion");
//        descDTO.setReviewUrl("afdasdf");
//        DescService.createDesc(descDTO, "123");
        
//        DescDTO descDTO = DescService.getDescByUuid("1234");
//		Map<String, Object> resultMap = new HashMap<>();
//		resultMap.put("descDTO", descDTO);
//        System.out.print(apiReturn(200, resultMap));
        
    }
}
