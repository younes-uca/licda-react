



export const MessageService = {

    showToast: (toastRef, options) => {
        if (toastRef && options) {
            toastRef.current?.show(options);
        }
    }
};
