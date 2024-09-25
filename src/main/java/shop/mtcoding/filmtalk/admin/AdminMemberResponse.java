        package shop.mtcoding.filmtalk.admin;

        import lombok.Data;
        import shop.mtcoding.filmtalk.user.User;

        import java.util.List;


        @Data
        public class AdminMemberResponse {
            private List<adminDTO> adminList;

            @Data
            public static class adminDTO{

                private Long id;
                private String username;
                private String email;
                private String phone;
                private String name;
                private String role;
                private Boolean approved;
                private String profileUrl;
                private Long cinemaId;

                public adminDTO(Admin admin) {
                    this.id = admin.getId();
                    this.username = admin.getUsername();
                    this.email = admin.getEmail();
                    this.phone = admin.getPhone();
                    this.name = admin.getName();
                    this.role = getRoleDisplayName(admin.getRole());
                    this.approved = admin.getApproved();
                    this.profileUrl = admin.getProfileUrl();
                    this.cinemaId = admin.getCinema() != null ? admin.getCinema().getId() : null;
                }
                // 역할을 한국어로 변환하는 메서드
                private String getRoleDisplayName(String role) {
                    switch (role) {
                        case "ROLE_SUPERADMIN":
                            return "최고 관리자"; // Master Manager
                        case "ROLE_ADMIN":
                            return "관리자"; // Manager
                        case "ROLE_USER":
                            return "일반 사용자"; // General User
                        default:
                            return "알 수 없음"; // Unknown role
                    }
                }

            }

        }
