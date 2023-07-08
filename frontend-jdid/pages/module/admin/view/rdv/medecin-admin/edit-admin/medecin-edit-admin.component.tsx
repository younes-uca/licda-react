import {Button} from 'primereact/button';
import {Column} from 'primereact/column';
import {Dropdown} from 'primereact/dropdown';
import {TabView, TabPanel} from 'primereact/tabview';
import {DataTable} from 'primereact/datatable';
import {Dialog} from 'primereact/dialog';
import {InputNumber, InputNumberChangeEvent} from 'primereact/inputnumber';
import {InputText} from 'primereact/inputtext';
import {classNames} from 'primereact/utils';
import { InputTextarea } from 'primereact/inputtextarea';
import {AxiosResponse} from 'axios';
import React, {useEffect, useState} from 'react';
import {Calendar, CalendarChangeEvent} from 'primereact/calendar';
import { format } from 'date-fns';
import {InputNumberChangeEvent} from 'primereact/inputnumber';
import { InputSwitch } from "primereact/inputswitch";
import {MultiSelect} from "primereact/multiselect";import {MessageService} from "/pages/controller/service/MessageService";

import {MedecinService} from '/pages/controller/service/Medecin.service';
import  {MedecinDto}  from '/pages/controller/model/Medecin.model';

import {CenterDto} from '/pages/controller/model/Center.model';
import {CenterService} from '/pages/controller/service/Center.service';
const Edit = ({visible, onClose, showToast, selectedItem, update}) => {

    const emptyItem = new MedecinDto();
    const [submitted, setSubmitted] = useState(false);
    const [activeIndex, setActiveIndex] = useState<number>(0);
    const [activeTab, setActiveTab] = useState(0);
    const [item, setItem] = useState<MedecinDto>( emptyItem);
    const [centers, setCenters] = useState<CenterDto[]>([]);
    type CenterResponse = AxiosResponse<CenterDto[]>;

    useEffect(() => {
        const fetchData = async () => {
            try {
                // if pojo = Commande this line must dispolay client (in command), product(in commanandItem)
                const [centersResponse ] = await Promise.all<CenterResponse>([
                    CenterService.getList(),
                ]);
                setCenters(centersResponse.data);
            } catch (error) {
                console.error(error);
            }
        };
    fetchData();
    setItem(selectedItem ? { ...selectedItem } : { ...emptyItem });
    }, [selectedItem]);



    const onDropdownChange = (e, field) => {
        setItem((prevState) => ({ ...prevState, [field]: e.value, }));
    };


    const onTabChange = (e: { index: number }) => {
        setActiveIndex(e.index);
    };

    const hideDialog = () => {
        setSubmitted(false);
        onClose();
    };

    const saveItem = async () => {
        setSubmitted(true);
        let _item = {...item};
        try {
            if (_item.id) {
                await MedecinService.update(_item).then((response) => {
                    console.log(response.data);
                    update(response.data);
                    onClose();
                });
                MessageService.showToast(showToast, { severity: 'success', summary: 'Successful', detail: 'Medecin Updated', life: 3000 });
            }
        } catch (error) {
            console.log(error);
            MessageService.showToast(showToast, { severity: 'Error', summary: 'Error', detail: 'Failed to save medecin', life: 3000 });
        }
    };

    const onInputTextChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        let _item = {...item};
        _item[`${name}`] = val;
        setItem(_item);
    };

    const onInputDateChange = (e: CalendarChangeEvent, name: string) => {
        const val = e.value || ''; // Utilisez e.value au lieu de e.target.value
        let _item = { ...item};
        _item[`${name}`] = val;
        setItem(_item);
    };

    const onInputNumerChange = (e: InputNumberChangeEvent, name: string) => {
        const val = e.value === null ? null : +e.value;
        setItem((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const onMultiSelectChange = (e, field) => {
        if (e && e.value && Array.isArray(e.value)) {
            const selectedValues = e.value.map(option => option && option.value);
            setItem(prevState => ({ ...prevState, [field]: selectedValues, }));
        }
    };

    const onBooleanInputChange = (e: any, name: string) => {
        const val = e.value;
        setItem((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const itemDialogFooter = ( <>
        <Button label="Cancel" icon="pi pi-times" text onClick={hideDialog} />
        <Button label="Save" icon="pi pi-check" text onClick={saveItem} /> < />
    );

return(
    <Dialog visible={visible} style={{width: '70vw'}} header="Medecin" modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog}>
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header="Medecin">
                <div className="formgrid grid">
                    <div className="field col-6">
                        <label htmlFor="email">Email</label>
                        <InputText id="email" value={item ? item.email : ''} onChange={(e) => onInputTextChange(e, 'email')} required autoFocus className={classNames({'p-invalid': submitted && !item.email})} />
                        {submitted && !item.email && <small className="p-invalid">Email is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="cin">Cin</label>
                        <InputText id="cin" value={item ? item.cin : ''} onChange={(e) => onInputTextChange(e, 'cin')} required autoFocus className={classNames({'p-invalid': submitted && !item.cin})} />
                        {submitted && !item.cin && <small className="p-invalid">Cin is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="nom">Nom</label>
                        <InputText id="nom" value={item ? item.nom : ''} onChange={(e) => onInputTextChange(e, 'nom')} required autoFocus className={classNames({'p-invalid': submitted && !item.nom})} />
                        {submitted && !item.nom && <small className="p-invalid">Nom is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="prenom">Prenom</label>
                        <InputText id="prenom" value={item ? item.prenom : ''} onChange={(e) => onInputTextChange(e, 'prenom')} required autoFocus className={classNames({'p-invalid': submitted && !item.prenom})} />
                        {submitted && !item.prenom && <small className="p-invalid">Prenom is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="center">Center</label>
                        <Dropdown  id="centerDropdown"  value={item ? item.center : ''} options={centers} onChange={(e) => onDropdownChange(e, 'center')}   placeholder="Sélectionnez un center" filter filterPlaceholder="Rechercher un center" optionLabel="libelle" />
                    </div>
                </div>
            < /TabPanel>
        </TabView>
    </Dialog>
);
};
export default Edit;


