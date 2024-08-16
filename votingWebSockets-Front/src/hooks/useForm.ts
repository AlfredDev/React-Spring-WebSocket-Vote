import { ChangeEvent, useState } from "react";

type FormState = Record<string, any>;

interface UseFormReturn {
    formState: FormState,
    onInputChange: (event: ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => void;
    onResetForm: () => void;
    [key: string]: any;
}

export const useForm = (initialForm: FormState = {}): UseFormReturn => {

    const [formState, setFormState] = useState<FormState>(initialForm);
    const onInputChange = (event: ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
        const { name, value } = event.target;
        setFormState(prevFormState => ({
            ...prevFormState,
            [name]: value
        }));
        console.log(formState);
    };

    const onResetForm = () => {
        setFormState(initialForm);
    };
    return {
        formState,
        onInputChange,
        onResetForm,
        ...formState
    };
}