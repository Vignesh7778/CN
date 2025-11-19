#include <stdio.h>
#include <string.h>
#include <arpa/inet.h>
#include <unistd.h>

int main() {
    int s = socket(AF_INET, SOCK_STREAM, 0);

    struct sockaddr_in serv;
    serv.sin_family = AF_INET;
    serv.sin_port = htons(9008);
    inet_pton(AF_INET, "127.0.0.1", &serv.sin_addr);

    connect(s, (struct sockaddr *)&serv, sizeof(serv));

    char msg[] = "Hello from C client\n";
    send(s, msg, strlen(msg), 0);

    close(s);
    return 0;
}
