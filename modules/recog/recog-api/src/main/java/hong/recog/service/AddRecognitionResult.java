package hong.recog.service;

import com.liferay.portal.kernel.model.User;
import hong.recog.model.Recognition;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRecognitionResult {

  private Recognition recognition;
  private List<User> managers;
}
