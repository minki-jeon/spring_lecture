package com.example.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
@RequiredArgsConstructor
@Transactional
public class Service9 {
    public void action1(String username, MultipartFile upload) {
        System.out.println("username = " + username);
        System.out.println("upload = " + upload.getOriginalFilename()); // 파일명

        try {
            // Read Upload-File (Client -> Server System)
            InputStream is = upload.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);

            // Write File (Server System -> Server Storage)
            String filePath = "D:/01.private_work/Choongang/workspaces/Temp/uploadFiles/" + upload.getOriginalFilename();
            OutputStream os = new FileOutputStream(filePath);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            try (bos; os; bis; is) {    // Stream.Close
                byte[] buffer = new byte[1024];
                int length;

                while ((length = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, length);
                }
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            new RuntimeException(e);
        }
    }

    public void action2(String address, MultipartFile upload) {
        System.out.println("address = " + address);
        System.out.println("upload = " + upload.getOriginalFilename());

        if (upload != null) {
            if (upload.getSize() > 0) {

                try {
                    // Read Upload-File (Client -> Server Application)
                    InputStream is = upload.getInputStream();
//                    BufferedInputStream bis = new BufferedInputStream(is);

                    // Write File (Server Application -> Server Storage)
                    String filePath = "D:/01.private_work/Choongang/workspaces/Temp/uploadFiles/" + upload.getOriginalFilename();
                    OutputStream os = new FileOutputStream(filePath);
                    BufferedOutputStream bos = new BufferedOutputStream(os);

                    try (is; bos; os;) {
//                        is.transferTo(os);

                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = is.read(buffer)) != -1) {
                            bos.write(buffer, 0, length);
                        }
                        bos.flush();
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

    public void action3(MultipartFile[] upload) {
        if (upload != null) {
            for (MultipartFile file : upload) {
                if (file.getSize() > 0) {
                    try {
                        String filePath = "D:/01.private_work/Choongang/workspaces/Temp/uploadFiles/" + file.getOriginalFilename();
                        var bis = new BufferedInputStream(file.getInputStream());
                        var bos = new BufferedOutputStream(new FileOutputStream(filePath));
                        try (bos; bis) {
                            byte[] buffer = new byte[1024];
                            int length;
                            while ((length = bis.read(buffer)) != -1) {
                                bos.write(buffer, 0, length);
                            }
                            bos.flush();
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
